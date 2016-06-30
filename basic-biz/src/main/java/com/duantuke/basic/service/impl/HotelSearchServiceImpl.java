package com.duantuke.basic.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.Mapper;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.common.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.esbean.input.HotelInputBean;
import com.duantuke.basic.face.esbean.output.HotelOutputBean;
import com.duantuke.basic.face.esbean.query.HotelQueryBean;
import com.duantuke.basic.face.service.HotelSearchService;
import com.duantuke.basic.face.service.PriceService;
import com.duantuke.basic.face.service.TagService;
import com.duantuke.basic.po.Tag;
import com.duantuke.basic.service.IHotelService;
import com.duantuke.basic.util.DateUtil;
import com.duantuke.basic.util.ThreadPoolUtil;
import com.duantuke.basic.util.elasticsearch.HotelElasticsearchUtil;
import com.google.gson.Gson;

/**
 * @author he 农家院 搜索相关接口
 */
@Service
public class HotelSearchServiceImpl implements HotelSearchService {

	private static Logger logger = LoggerFactory.getLogger(HotelSearchServiceImpl.class);

	@Autowired
	private HotelElasticsearchUtil esutil;
	@Autowired
	private IHotelService ihotelService;
	@Autowired
	private PriceService priceService;
	@Autowired
	private TagService tagService;
	@Autowired
    private Mapper dozerMapper;

	private Gson gson = new Gson();

	@Override
	public List<HotelOutputBean> searchHotelsFromEs(HotelQueryBean hotelQueryBean) {
		logger.info("HotelSearchServiceImpl searchHotelsFromEs param:{}", gson.toJson(hotelQueryBean));
		// page参数校验：如果page小于等于0，默认为1.
		Integer page = hotelQueryBean.getPage();
		if ((null == page) || (page <= 0)) {
			page = HotelQueryBean.SEARCH_PAGE_DEFAULT;
			hotelQueryBean.setPage(page);
		}
		// size参数校验：如果size小于等于0，默认为10.
		Integer pagesize = hotelQueryBean.getPagesize();
		if ((null == pagesize) || (pagesize <= 0)) {
			pagesize = HotelQueryBean.SEARCH_LIMIT_DEFAULT;
			hotelQueryBean.setPagesize(pagesize);
		}
		if (hotelQueryBean.getRange() == null) {
			hotelQueryBean.setRange(Double.valueOf(HotelQueryBean.SEARCH_RANGE_DEFAULT));
		}
		Map<String,List<String>> tagmap = new HashMap<String,List<String>>();
		if(StringUtils.isNotEmpty(hotelQueryBean.getTagJson())){
			tagmap = gson.fromJson(hotelQueryBean.getTagJson(), Map.class);
		}
		List<HotelOutputBean> result = esutil.searchHotels(hotelQueryBean,tagmap);
		logger.info("HotelSearchServiceImpl searchHotelsFromEs result:{}", gson.toJson(result));
		return result;
	}

	@Override
	public void initEs(Long hotelId) {
		logger.info("HotelSearchServiceImpl initEs begin:{}", hotelId);
		List<HotelInputBean> esInputlist = ihotelService.queryEsInputHotels(hotelId);
		
		final CountDownLatch doneSingal = new CountDownLatch(esInputlist.size());
		//多线程
		for (final HotelInputBean hotelInputBean:esInputlist) {
			ThreadPoolUtil.pool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						if ((hotelInputBean.getLatitude() != null) && (hotelInputBean.getLongitude() != null)) {
							hotelInputBean.setPin(new GeoPoint(hotelInputBean.getLatitude().doubleValue(), hotelInputBean.getLongitude().doubleValue()));
						}
						hotelInputBean.setCreatetime(DateUtil.dateToStr(DateUtil.getNowDate(), "yyyy-MM-dd HH:mm"));
						//保存tag
						List<Tag> taglist = tagService.queryTagsByHotelId(hotelInputBean.getHotelId());
						for (Tag tag:taglist) {
							Map<String,String> map = dozerMapper.map(tag, Map.class);
							if(tag.getTagGroupId().equals(1l)){
								hotelInputBean.getTaggroup_1().add(map);
							}else if(tag.getTagGroupId().equals(2l)){
								hotelInputBean.getTaggroup_2().add(map);
							}else if(tag.getTagGroupId().equals(3l)){
								hotelInputBean.getTaggroup_3().add(map);
							}else if(tag.getTagGroupId().equals(4l)){
								hotelInputBean.getTaggroup_4().add(map);
							}
						}
						hotelInputBean.setPrices(getPrices(hotelInputBean.getHotelId()));
					}catch (Exception e) {
						logger.error("HotelSearchServiceImpl initEs error", e);
				    } finally {
					   doneSingal.countDown();
					   ThreadPoolUtil.threadSleep(ThreadPoolUtil.threadSleep);
				    }
				}
			});
		}
		try {
			doneSingal.await();
		} catch (InterruptedException e) {
			logger.error("HotelSearchServiceImpl initEs InterruptedException",e);
		}
		if(CollectionUtils.isNotEmpty(esInputlist)){
			esutil.batchAddDocument(esInputlist);
		}else{
			logger.warn("HotelSearchServiceImpl initEs warn list is empty:{}", hotelId);
		}
		logger.info("HotelSearchServiceImpl initEs end:{}", hotelId);
	}
	
	private List<Map<String,Double>> getPrices(Long hotelid) throws Exception{
		List<Map<String,Double>> prices = new ArrayList<Map<String,Double>>();
		//按hotelid和otatype分组30天内价格最高值和最低值
		Calendar startc = Calendar.getInstance();
		Calendar endc = Calendar.getInstance();
		endc.add(Calendar.DAY_OF_MONTH, 31);
		
		Map<Long,Map<String,BigDecimal>> pricemap = priceService.queryHotelPrices(hotelid, startc.getTime(), endc.getTime(), null);
		//按天按房型分组
		List<Date> dateList = new ArrayList<Date>();
        dateList = DateUtil.listDays(startc.getTime(), endc.getTime());
        try {
        	for (Date date : dateList) {
        		BigDecimal minprice =  BigDecimal.valueOf(999999);
        		String datestr = DateUtil.dateToStr(date, "yyyyMMdd");
        		Map<String,Double> map = new HashMap<String,Double>();
        		//按房型
        		for (Long roomtypeid:pricemap.keySet()) {
        			Map<String,BigDecimal> infomap= pricemap.get(roomtypeid);
        			BigDecimal temprice = infomap.get(datestr);
        			if(temprice.compareTo(minprice)==-1){
        				minprice = temprice;
        			}
        		}
        		if(minprice.compareTo(BigDecimal.valueOf(999999))==0){
        			continue;
        		}
        		map.put(datestr, minprice.doubleValue());
        		prices.add(map);
        	}
		} catch (Exception e) {
			logger.error("价格报错~hotelid:"+hotelid,e);
		}
		return prices;
		
	}
	
	

	@Override
	public void refreshesprice(Long hotelId) throws Exception {
		logger.info("HotelSearchServiceImpl refreshesprice begin:{}", hotelId);
		List<HotelInputBean> esInputlist = ihotelService.queryEsInputHotels(hotelId);
		
		final CountDownLatch doneSingal = new CountDownLatch(esInputlist.size());
		
		for (final HotelInputBean hotelInputBean:esInputlist) {
			ThreadPoolUtil.pool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						List<Map<String,Double>> priceslist = new ArrayList<Map<String,Double>>();
						priceslist = getPrices(hotelInputBean.getHotelId());
						esutil.updateDocument(hotelInputBean.getHotelId()+"", "prices", priceslist);
					}catch (Exception e) {
						logger.error("HotelSearchServiceImpl refreshesprice error", e);
				    } finally {
					   doneSingal.countDown();
					   ThreadPoolUtil.threadSleep(ThreadPoolUtil.threadSleep);
				    }
				}
			});
		}
		try {
			doneSingal.await();
		} catch (InterruptedException e) {
			logger.error("HotelSearchServiceImpl refreshesprice InterruptedException",e);
		}
	}
	
	@Override
	public void refreshestag(Long hotelId) throws Exception {
		logger.info("HotelSearchServiceImpl refreshestag begin:{}", hotelId);
		List<HotelInputBean> esInputlist = ihotelService.queryEsInputHotels(hotelId);
		
		final CountDownLatch doneSingal = new CountDownLatch(esInputlist.size());
		
		for (final HotelInputBean hotelInputBean:esInputlist) {
			ThreadPoolUtil.pool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						List<Tag> taglist = tagService.queryTagsByHotelId(hotelInputBean.getHotelId());
						for (Tag tag:taglist) {
							Map<String,String> map = dozerMapper.map(tag, Map.class);
							if(tag.getTagGroupId().equals(1l)){
								hotelInputBean.getTaggroup_1().add(map);
							}else if(tag.getTagGroupId().equals(2l)){
								hotelInputBean.getTaggroup_2().add(map);
							}else if(tag.getTagGroupId().equals(3l)){
								hotelInputBean.getTaggroup_3().add(map);
							}else if(tag.getTagGroupId().equals(4l)){
								hotelInputBean.getTaggroup_4().add(map);
							}
						}
						esutil.updateDocument(hotelInputBean.getHotelId()+"", "taggroup_1", hotelInputBean.getTaggroup_1());
						esutil.updateDocument(hotelInputBean.getHotelId()+"", "taggroup_2", hotelInputBean.getTaggroup_2());
						esutil.updateDocument(hotelInputBean.getHotelId()+"", "taggroup_3", hotelInputBean.getTaggroup_3());
						esutil.updateDocument(hotelInputBean.getHotelId()+"", "taggroup_4", hotelInputBean.getTaggroup_4());
					}catch (Exception e) {
						logger.error("HotelSearchServiceImpl refreshestag error", e);
				    } finally {
					   doneSingal.countDown();
					   ThreadPoolUtil.threadSleep(ThreadPoolUtil.threadSleep);
				    }
				}
			});
		}
		try {
			doneSingal.await();
		} catch (InterruptedException e) {
			logger.error("HotelSearchServiceImpl refreshestag InterruptedException",e);
		}
	}

	@Override
	public boolean delEsByHotelId(Long hotelId) {
		DeleteResponse resp = esutil.deleteDocument(hotelId+"");
		return resp.isFound();
	}

	@Override
	public void delEs() {
		esutil.deleteAllDocument();
	}

}
