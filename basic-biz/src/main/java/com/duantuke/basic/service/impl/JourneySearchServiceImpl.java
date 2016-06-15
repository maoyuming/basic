package com.duantuke.basic.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.common.geo.GeoPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.esbean.input.JourneyInputBean;
import com.duantuke.basic.face.esbean.output.JourneyOutputBean;
import com.duantuke.basic.face.esbean.query.JourneyQueryBean;
import com.duantuke.basic.face.service.JourneySearchService;
import com.duantuke.basic.face.service.TagService;
import com.duantuke.basic.po.JourneyRHotel;
import com.duantuke.basic.po.JourneyRSight;
import com.duantuke.basic.po.Tag;
import com.duantuke.basic.service.IJourneyService;
import com.duantuke.basic.util.DateUtil;
import com.duantuke.basic.util.elasticsearch.JourneyElasticsearchUtil;
import com.duantuke.basic.util.elasticsearch.ThreadPoolUtil;
import com.google.gson.Gson;

/**
 * @author he 游记 搜索相关接口
 */
@Service
public class JourneySearchServiceImpl implements JourneySearchService {

	private static Logger logger = LoggerFactory.getLogger(JourneySearchServiceImpl.class);

	@Autowired
	private JourneyElasticsearchUtil esutil;
	@Autowired
	private IJourneyService ijourneyService;

	private Gson gson = new Gson();

	@Override
	public List<JourneyOutputBean> searchJourneysFromEs(JourneyQueryBean journeyQueryBean,Map<String,List<String>> hotelIds,Map<String,List<String>> sightIds) {
		logger.info("JourneySearchServiceImpl searchJourneysFromEs param:{}", gson.toJson(journeyQueryBean));
		// page参数校验：如果page小于等于0，默认为1.
		Integer page = journeyQueryBean.getPage();
		if ((null == page) || (page <= 0)) {
			page = JourneyQueryBean.SEARCH_PAGE_DEFAULT;
			journeyQueryBean.setPage(page);
		}
		// size参数校验：如果size小于等于0，默认为10.
		Integer pagesize = journeyQueryBean.getPagesize();
		if ((null == pagesize) || (pagesize <= 0)) {
			pagesize = JourneyQueryBean.SEARCH_LIMIT_DEFAULT;
			journeyQueryBean.setPagesize(pagesize);
		}
		if (journeyQueryBean.getRange() == null) {
			journeyQueryBean.setRange(Double.valueOf(JourneyQueryBean.SEARCH_RANGE_DEFAULT));
		}
		List<JourneyOutputBean> result = esutil.searchJourneys(journeyQueryBean,hotelIds,sightIds);
		logger.info("JourneySearchServiceImpl searchJourneysFromEs result:{}", gson.toJson(result));
		return result;
	}

	@Override
	public void initEs(Long journeyId) {
		logger.info("JourneySearchServiceImpl initEs begin:{}", journeyId);
		List<JourneyInputBean> esInputlist = ijourneyService.queryEsInputJourneys(journeyId);
		final CountDownLatch doneSingal = new CountDownLatch(esInputlist.size());
		// 为多线程
		for (final JourneyInputBean journeyInputBean:esInputlist) {
			ThreadPoolUtil.pool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						journeyInputBean.setCreatetime(DateUtil.dateToStr(DateUtil.getNowDate(), "yyyy-MM-dd HH:mm"));
						//保存关联关系
						List<JourneyRHotel> hotellist = ijourneyService.queryHotelIdsByJourneyId(journeyInputBean.getJourneyId());
						List<JourneyRSight> sightlist = ijourneyService.queryHotelIdsBySightId(journeyInputBean.getJourneyId());
						for (JourneyRHotel hotel:hotellist) {
							Map<String,String> map = new HashMap<String,String>();
							map.put("hotelId", hotel.getHotelId()+"");
							journeyInputBean.getHotelIds().add(map);
						}
						for (JourneyRSight sight:sightlist) {
							Map<String,String> map = new HashMap<String,String>();
							map.put("sightId", sight.getSightId()+"");
							journeyInputBean.getSightIds().add(map);
						}
					}catch (Exception e) {
						logger.error("JourneySearchServiceImpl initEs error", e);
				    } finally {
					   doneSingal.countDown();
					   ThreadPoolUtil.threadSleep(ThreadPoolUtil.threadSleep);
				    }
				}
			});
		}
		esutil.batchAddDocument(esInputlist);
		logger.info("JourneySearchServiceImpl initEs end:{}", journeyId);
	}

	@Override
	public boolean delEsByJourneyId(Long journeyId) {
		DeleteResponse resp = esutil.deleteDocument(journeyId+"");
		return resp.isFound();
	}

	@Override
	public void delEs() {
		esutil.deleteAllDocument();
	}

}
