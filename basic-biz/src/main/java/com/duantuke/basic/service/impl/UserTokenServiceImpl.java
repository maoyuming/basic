package com.duantuke.basic.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.json.ParseException;
import com.duantuke.basic.core.RedisCacheManager;
import com.duantuke.basic.exception.OpenException;
import com.duantuke.basic.face.UserTokenTypeEnum;
import com.duantuke.basic.face.base.CacheKey;
import com.duantuke.basic.face.service.BossService;
import com.duantuke.basic.face.service.CustomerService;
import com.duantuke.basic.face.service.UserTokenService;
import com.duantuke.basic.mappers.UserTokenMapper;
import com.duantuke.basic.po.Boss;
import com.duantuke.basic.po.Customer;
import com.duantuke.basic.po.UserToken;
import com.duantuke.basic.po.UserTokenExample;
import com.duantuke.basic.util.Config;
import com.duantuke.basic.util.DateUtil;
import com.duantuke.basic.util.MD5Util;
import com.google.gson.Gson;

/**
 * 用户token查询和生成
 * @author tankai
 *
 */
@Service
public class UserTokenServiceImpl implements UserTokenService{
	private static Logger logger = LoggerFactory.getLogger(UserTokenServiceImpl.class);
	@Autowired
	private UserTokenMapper userTokenMapper;
	@Autowired
	private BossService bossService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private RedisCacheManager redisCacheManager;
	
	@Override
	public String genUserToken(UserTokenTypeEnum userTokenTypeEnum, String phone) {
		logger.info("查询和生成token，类型：{},手机号码：{}",userTokenTypeEnum.getName(),phone);
		try {
			String key = phone+"_"+userTokenTypeEnum.getId();
			Long  userId = queryUserIdByPhone(userTokenTypeEnum, phone);

			UserTokenExample example = new UserTokenExample();
			UserTokenExample.Criteria hoCriteria = example.createCriteria();
			hoCriteria.andMidEqualTo(userId);
			example.setOrderByClause("token_sort desc");
			example.setLimitStart(0);
			example.setLimitEnd(1);
			
			List<UserToken> list = userTokenMapper.selectByExample(example);
			
			Date expireTime = null;
			try {
				expireTime = DateUtil.getDay(Integer.valueOf(Config.getValue("token.expireTime")));
			} catch (java.text.ParseException e) {
				
			}
			int sort=1;
			
			if(CollectionUtils.isNotEmpty(list)){
				sort += list.get(0).getTokenSort();
			}
			
			//gen token
			UserToken userToken = new UserToken();
			
			userToken.setMid(userId);
			userToken.setType(userTokenTypeEnum.getId());
			userToken.setTokenSort(sort);
			userToken.setExpireTime(expireTime);
			String token = MD5Util.encryption(Config.getValue("user.token")+key+System.currentTimeMillis());
			userToken.setToken(token);
			userTokenMapper.insertSelective(userToken);
			
			//存入redis
			saveTokenIntoRedis(key, userToken, expireTime);
			logger.info("手机号码：{},token={}",phone,new Gson().toJson(userToken) );
			
			return token;
		} catch (Exception e) {
			logger.error("生成token异常",e);
			throw new OpenException("token失效");
		}
		
	}
	
	/**
	 * 生成token
	 */
//	@Override
//	public String genUserToken(UserTokenTypeEnum userTokenTypeEnum, String phone) {
//		logger.info("查询和生成token，类型：{},手机号码：{}",userTokenTypeEnum.getName(),phone);
//		try {
//			//check redis中该用户token是否存在
//			String key = phone+"_"+userTokenTypeEnum.getId();
//			Object obj = redisCacheManager.getExpires(CacheKey.CACHE_NAME_USER, key);
//			
//			Date expireTime = null;
//			try {
//				expireTime = DateUtil.getDay(Integer.valueOf(Config.getValue("token.expireTime")));
//			} catch (ParseException e) {
//				
//			}
//			
//			if(obj==null){//token不存在
//				//gen token
//				UserToken userToken = new UserToken();
//				
//				Long  userId = queryUserIdByPhone(userTokenTypeEnum, phone);
//				userToken.setMid(userId);
//				userToken.setType(userTokenTypeEnum.getId());
//				
//				userToken.setExpireTime(expireTime);
//				String token = MD5Util.encryption(Config.getValue("user.token")+key);
//				userToken.setToken(token);
//				userTokenMapper.insertSelective(userToken);
//				
//				//存入redis
//				saveTokenIntoRedis(key, userToken, expireTime);
//				logger.info("手机号码：{},token={}",phone,new Gson().toJson(userToken) );
//				return token;
//			}else{
//				UserToken userToken = new Gson().fromJson((String)obj, UserToken.class);
//				if(userToken.getExpireTime().after(new Date())){//失效时间在当前时间后边
//					//失效时间延后一周。
//					
//					userToken.setExpireTime(expireTime);
//					//update数据
//					userTokenMapper.updateByPrimaryKeySelective(userToken);
//
//					//存入redis
//					saveTokenIntoRedis(key, userToken, expireTime);
//					
//					logger.info("手机号码：{},token={}",phone,new Gson().toJson(userToken) );
//					return  userToken.getToken();
//				}else{
//					throw new OpenException("token失效");
//				}
//			}
//		} catch (Exception e) {
//			logger.error("生成token异常",e);
//			throw new OpenException("token失效");
//		}
//		
//	}
	
	/**
	 * 保存token到redis中
	 * @param key
	 * @param userToken
	 * @param expireTime
	 */
	private void saveTokenIntoRedis(String key,UserToken userToken,Date expireTime){
		//存入redis
		//key:用户id_系统类型 value：usertoken 的json串
		redisCacheManager.setExpires(CacheKey.CACHE_NAME_USER, key, new Gson().toJson(userToken), DateUtil.diffDay(new Date(),expireTime));
		//key:token value：usertoken 的json串
		redisCacheManager.setExpires(CacheKey.CACHE_NAME_TOKEN, userToken.getToken(), new Gson().toJson(userToken), DateUtil.diffDay(new Date(),expireTime));
	}

	/**
	 * 根据token获取用户信息
	 */
	@Override
	public Long queryUserByUserToken(String token) {

		logger.info("开始查询用户信息，token="+token);
		//check redis中该用户token是否存在
		Object obj = redisCacheManager.getExpires(CacheKey.CACHE_NAME_TOKEN, token);
		if(obj==null){
			//token不存在
			throw new OpenException("用户信息不存在");
		}else{

			UserToken userToken = new Gson().fromJson((String)obj, UserToken.class);
			if(userToken.getExpireTime().before(new Date())){//失效时间在当前时间后边

				//token失效
				throw new OpenException("用户token失效");
			}else{
				logger.info("查询用户信息结果，{}",(String)obj);
				return userToken.getMid();
			}
		}
	}
	
	/**
	 * 根据号码查询用户id
	 * @param userTokenTypeEnum
	 * @param phone
	 * @return
	 */
	private Long queryUserIdByPhone(UserTokenTypeEnum userTokenTypeEnum, String phone){
		switch (userTokenTypeEnum) {
		case B:
			Boss boss = bossService.queryBossByPhone(phone);
			if(boss==null){
				throw new OpenException("用户不存在");
			}
			
			return boss.getBossId();
		case C:
			Customer customer = customerService.queryCustomerByPhone(phone);
			if(customer==null){
				throw new OpenException("用户不存在");
			}
			return customer.getCustomerId();

		default:
			break;
		}
		return null;
	}
	
}
