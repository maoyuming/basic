package com.duantuke.basic.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.enums.IsvisibleEnum;
import com.duantuke.basic.exception.OpenException;
import com.duantuke.basic.face.service.PriceService;
import com.duantuke.basic.face.service.RoomTypeService;
import com.duantuke.basic.mappers.DailyRateMapper;
import com.duantuke.basic.mappers.RackRateMapper;
import com.duantuke.basic.mappers.WeekendRateMapper;
import com.duantuke.basic.po.BossExample;
import com.duantuke.basic.po.DailyRate;
import com.duantuke.basic.po.DailyRateExample;
import com.duantuke.basic.po.RackRate;
import com.duantuke.basic.po.RackRateExample;
import com.duantuke.basic.po.RoomType;
import com.duantuke.basic.po.WeekendRate;
import com.duantuke.basic.po.WeekendRateExample;
import com.duantuke.basic.util.DateUtil;

@Service
public class PriceServiceImpl implements PriceService{
	
	@Autowired
	private DailyRateMapper dailyRateMapper;
	@Autowired
	private RoomTypeService roomTypeService;
	@Autowired
	private WeekendRateMapper weekendRateMapper;
	@Autowired
	private RackRateMapper rackRateMapper;

	public static final Logger logger = LoggerFactory.getLogger(PriceServiceImpl.class);
	public static final int DEFAULTDAYS = 30;
	

	/**
	 * 查询价格服务
	 * Map<Long, Map<String, BigDecimal>> key:房型id  value:Map<String, BigDecimal> 时间价格集合
	 *    
	 * Map<String, BigDecimal> key:时间 格式yyyyMMdd，value:价格
	 */
	@Override
	public Map<Long, Map<String, BigDecimal>> queryHotelPrices(Long hotelId,
			String begintime, String endtime, List<Long> roomtypeIds) {
		if(begintime==null){
			throw new OpenException("开始时间为空");
		}
		if(endtime==null){
			throw new OpenException("结束时间为空");
		}
		Date begin = DateUtil.strToDate(begintime, DateUtil.DateFormat);
		Date end = DateUtil.strToDate(endtime,  DateUtil.DateFormat);
		return this.queryHotelPrices(hotelId, begin, end, roomtypeIds);
	}
	
	@Override
	public Map<Long, Map<String, BigDecimal>> queryHotelPrices(Long hotelId,
			Date begintime, Date endtime, List<Long> roomtypeIds) {
		if(begintime==null){
			throw new OpenException("开始时间为空");
		}
		if(endtime==null){
			throw new OpenException("结束时间为空");
		}
		//排除掉结束的这一天
		endtime = DateUtil.addDays(endtime,-1);
		
		logger.info("findRackRateByConditions:hotelid:{},roomtypeids:{},begintime:{},endtime:{}", hotelId, roomtypeIds, begintime, endtime);
		Date begintime_ = (Date) begintime.clone();
		// 特殊价
//		int begin = Integer.parseInt(DateUtil.dateToStr(begintime, "yyyyMMdd"));
//		int end = Integer.parseInt(DateUtil.dateToStr(endtime, "yyyyMMdd"));
		List<DailyRate> dailyRates = dailyRateMapper.findDailyRates(hotelId, roomtypeIds,begintime, endtime);

		// 周末价
		List<Integer> weeks = new ArrayList<>();
		while (begintime_.before(endtime) || begintime_.equals(endtime)) {
			weeks.add(DateUtil.getWeekTime(DateUtil.dateToStr(begintime_, "yyyyMMdd")));
			begintime_ = DateUtil.addDays(begintime_, 1);
		}
		List<WeekendRate> weekendRates = weekendRateMapper.findWeekendRates(hotelId, roomtypeIds, weeks);

		// 平日价
		RackRateExample rackRateExample = new RackRateExample();
		if (hotelId != null) {
			RackRateExample.Criteria criteria = rackRateExample.or();
			criteria.andHotelIdEqualTo(hotelId);
		}
		if (CollectionUtils.isNotEmpty(roomtypeIds)) {
			RackRateExample.Criteria criteria = rackRateExample.or();
			criteria.andRoomtypeIdIn(roomtypeIds);
		}
		// 1、查酒店的门市价
		List<RackRate> rackRates = rackRateMapper.selectByExample(rackRateExample);
		
		begintime_ = (Date) begintime.clone();
		Map<String, BigDecimal> resultMap = new HashMap<>();
		while (begintime_.before(endtime) || begintime_.equals(endtime)) {
			String yyyymmdd = DateUtil.dateToStr(begintime_, "yyyyMMdd");
			Map<String, BigDecimal> rackMap = new HashMap<>();
			// 1、初始化rackMap，数据为：房型id@20150524--->120(优先级3)
			for (RackRate rackRate : rackRates) {
				rackMap.put(rackRate.getRoomtypeId() + "@" + yyyymmdd, rackRate.getPrice());
			}
			// 2、周末价往里放(优先级2)
			for (WeekendRate weekRate : weekendRates) {
				int w = DateUtil.getWeekTime(yyyymmdd);
				// 判断是否和今天星期几一致
				if (w == weekRate.getWeek()) {
					rackMap.put(weekRate.getRoomtypeId() + "@" + yyyymmdd, weekRate.getPrice());
				}
			}
			// 3、特殊价往里放(优先级1)
			for (DailyRate dailyRate : dailyRates) {
				// 判断day是否和当天一致
				if (String.valueOf(dailyRate.getDay()).equals(yyyymmdd)) {
					rackMap.put(dailyRate.getRoomtypeId() + "@" + yyyymmdd, dailyRate.getPrice());
				}
			}
			resultMap.putAll(rackMap);
			begintime_ = DateUtil.addDays(begintime_, 1);
		}
		logger.info("findRackRateByConditions:返回结果:{}", resultMap);
		
		
		 Map<Long, Map<String, BigDecimal>> map = new HashMap<Long, Map<String,BigDecimal>>();
		for (Entry<String, BigDecimal> entry : resultMap.entrySet()) {
		
			String[] array = entry.getKey().split("@");
			Long roomtypeId = Long.valueOf(array[0]);	
			if(map.containsKey(roomtypeId)){
				map.get(roomtypeId).put(array[1], entry.getValue());
			}else{
				Map<String, BigDecimal> dataMap =new HashMap<String, BigDecimal>();
				dataMap.put(array[1], entry.getValue());
				map.put(roomtypeId, dataMap);
			}
		}
		return map;
	}

	
}
