package com.duantuke.basic.service.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.common.geo.GeoPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.esbean.input.HotelInputBean;
import com.duantuke.basic.face.esbean.output.HotelOutputBean;
import com.duantuke.basic.face.esbean.query.HotelQueryBean;
import com.duantuke.basic.face.service.HotelSearchService;
import com.duantuke.basic.face.service.TagService;
import com.duantuke.basic.po.Tag;
import com.duantuke.basic.service.IHotelService;
import com.duantuke.basic.util.DateUtil;
import com.duantuke.basic.util.elasticsearch.HotelElasticsearchUtil;
import com.duantuke.basic.util.elasticsearch.ThreadPoolUtil;
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
	private TagService tagService;

	private Gson gson = new Gson();

	@Override
	public List<HotelOutputBean> searchHotelsFromEs(HotelQueryBean hotelQueryBean,Map<String,List<String>> tags) {
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
		List<HotelOutputBean> result = esutil.searchHotels(hotelQueryBean,tags);
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
							if(tag.getTagGroupId().equals(1l)){
								hotelInputBean.getTaggroup_1().add(tag);
							}else if(tag.getTagGroupId().equals(2l)){
								hotelInputBean.getTaggroup_2().add(tag);
							}else if(tag.getTagGroupId().equals(3l)){
								hotelInputBean.getTaggroup_3().add(tag);
							}else if(tag.getTagGroupId().equals(4l)){
								hotelInputBean.getTaggroup_4().add(tag);
							}
						}
					}catch (Exception e) {
						logger.error("HotelSearchServiceImpl initEs error", e);
				    } finally {
					   doneSingal.countDown();
					   ThreadPoolUtil.threadSleep(ThreadPoolUtil.threadSleep);
				    }
				}
			});
		}
		esutil.batchAddDocument(esInputlist);
		logger.info("HotelSearchServiceImpl initEs end:{}", hotelId);
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
