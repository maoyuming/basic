package com.duantuke.basic.face.service;

import com.duantuke.basic.face.UserTokenTypeEnum;

public interface UserTokenService {
	
	/**
	 * 根据用户id获取token
	 * @param userTokenTypeEnum
	 * @param phone
	 * @return
	 */
	public String genUserToken(UserTokenTypeEnum userTokenTypeEnum,String phone);
	
	/**
	 * 根据token查询用户id
	 * @param token
	 * @return
	 */
	public Long queryUserByUserToken(String token);
}
