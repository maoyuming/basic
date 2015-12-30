package com.fangbaba.basic.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fangbaba.basic.face.bean.HotelModel;
import com.fangbaba.basic.face.bean.vo.HotelVo;
import com.fangbaba.basic.service.impl.HotelServiceImpl;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext*.xml" })
public class HotelServiceTest extends AbstractTransactionalJUnit4SpringContextTests{

    @Autowired
    private HotelServiceImpl hotelServiceImpl;
    
    
    @Before
    public void before(){

        String sql = "delete from hotel";
        jdbcTemplate.update(sql);
    
    }
    @Test
	public  void testQueryAllHotels() {
    	String sql = "INSERT INTO `hotel` VALUES (399, '上轩商务酒店', '上轩商务', '2015-3-26 17:12:27', '天津市和平区', 117.19590800, 39.11832800, '2014-1-28 00:00:00', '2014-2-11 00:00:00', 68, '性价比高，住宿环境、通风采光较好。', 'https://dn-imke-pro.qbox.me/FmalZsisRpZVQMWKauH3vDFJDmub', '', '3ZyeYNlYZ6LEhi6WWak123', 'T', 'T', '', '', '180000', '120000', '021-56792199', 2, 500101, '010-8189001', 500000, 500000, NULL);";
    	jdbcTemplate.update(sql);
    	 
    	List<HotelModel> list =  hotelServiceImpl.queryAllHotels();
    	

		Assert.assertNotNull(list);
		Assert.assertEquals(list.size()==1,true);
		
    }
    @Test
	public void testQueryById() {
    	String sql = "INSERT INTO `hotel` VALUES (399, '上轩商务酒店', '上轩商务', '2015-3-26 17:12:27', '天津市和平区', 117.19590800, 39.11832800, '2014-1-28 00:00:00', '2014-2-11 00:00:00', 68, '性价比高，住宿环境、通风采光较好。', 'https://dn-imke-pro.qbox.me/FmalZsisRpZVQMWKauH3vDFJDmub', '', '3ZyeYNlYZ6LEhi6WWak123', 'T', 'T', '', '', '180000', '120000', '021-56792199', 2, 500101, '010-8189001', 500000, 500000, NULL);";
    	jdbcTemplate.update(sql);
    	 
    	HotelModel hotelModel =  hotelServiceImpl.queryById(399L);    	

		Assert.assertNotNull(hotelModel);
		Assert.assertEquals(hotelModel.getHotelname().equals("上轩商务酒店"),true);
	}

    @Test
    //@Rollback(false)
    public void testSyncHotelInfo(){
    	String sql = "INSERT INTO `hotel` (`id`, `hotelname`, `hotelcontactname`, `regtime`, `detailaddr`, `longitude`, `latitude`, `opentime`, `repairtime`, `roomnum`, `introduction`, `businesslicensefront`, `businesslicenseback`, `hotelpms`, `isvisible`, `isonline`, `idcardfront`, `idcardback`, `retentiontime`, `defaultleavetime`, `hotelphone`, `hoteltype`, `discode`, `qtphone`, `citycode`, `provcode`, `pmstype`) VALUES ('410', '万鑫全时尚宾馆', '翁老板', '2015-03-30 12:28:10', '川黄路191号', '0.00000000', '0.00000000', '2013-02-01 00:00:01', '2013-02-01 00:00:01', '43', '\"上海万鑫全时尚宾馆位于上海市迪斯尼板块川沙镇，步行即可达川沙古镇。上海万鑫全时尚宾馆是一家集创意、设计、装饰、培训为一体的主题概念酒店，坚持“个性与原创、舒适与环保”的设计理念，以时尚、前卫为主题，定位于休闲、都市、潮流。宾馆房间设计新颖，线条简练，更配备有空调、电视等，为您旅游休闲提供便利的住宿体验\"', 'https://dn-imke-pro.qbox.me/FnYB1nVDMl-AJ81pNeOgLs9exfk0', '', '2zCMvWZL9bIWgvq5MZ8pv3', 'T', 'T', '', '', '200000', '120000', '021-50965796', NULL, '310115', '', '310000', '310000', NULL)";
    	String sql1 = "INSERT INTO `roomtype` (`id`, `hotelid`, `name`, `roomtypepms`, `roomnum`, `cost`) VALUES ('234', '410', '时尚圆床房', '1HIIGTijVcs9cIm8QyO7s7l', '5', '188.00')";
    	String sql2="INSERT INTO `room` (`id`, `roomtypeid`, `roomno`, `roompms`, `tel`, `remark`) VALUES ('2568', '234', '8303', '1g2gDyXAZ3CHaVanBjKVLU', '', NULL)";
    	jdbcTemplate.update(sql);
    	jdbcTemplate.update(sql1);
    	jdbcTemplate.update(sql2);
    	String json = "{\"pmstypeid\":1,\"hotelid\":\"2zCMvWZL9bIWgvq5MZ8pv3\",\"phone\":18600210340,\"roomtypes\":[{\"id\":\"0TIH30Ma52eWwvErie0JkI\",\"name\":\"hehe\",\"price\":\"300\",\"rooms\":[{\"id\":\"2eiNyEOzhaCXOXIPXMMmJCG\",\"roomno\":\"1111\"}]},{\"id\":\"174We7hIxdaV8mRg5aN31qj\",\"name\":\"nimei\",\"price\":\"299\",\"rooms\":[{\"id\":\"1eLf2qEBdeeXtBy1aOgXzx\",\"roomno\":\"2222\"}]}]}";
    	hotelServiceImpl.syncHotelInfo(json);
    	
    	HotelModel hotelModel =  hotelServiceImpl.queryById(410L); 
		Assert.assertNotNull(hotelModel);
		Assert.assertEquals(hotelModel.getHotelphone().equals("18600210340"),true);
    }
    @Test
    public void queryDetail(){
    	String sql = "INSERT INTO `hotel` VALUES (399, '上轩商务酒店', '上轩商务', '2015-3-26 17:12:27', '天津市和平区', 117.19590800, 39.11832800, '2014-1-28 00:00:00', '2014-2-11 00:00:00', 68, '性价比高，住宿环境、通风采光较好。', 'https://dn-imke-pro.qbox.me/FmalZsisRpZVQMWKauH3vDFJDmub', '', '3ZyeYNlYZ6LEhi6WWak123', 'T', 'T', '', '', '180000', '120000', '021-56792199', 2, 500101, '010-8189001', 500000, 500000, NULL);";
    	jdbcTemplate.update(sql);
    	Long id = 399l;
    	HotelVo vo = hotelServiceImpl.queryDetail(id, null, null);
    	Assert.assertNotNull(vo);
    }
    @Test
    public void queryByPms(){
    	String sql = "INSERT INTO `hotel` (`id`, `hotelname`, `hotelcontactname`, `regtime`, `detailaddr`, `longitude`, `latitude`, `opentime`, `repairtime`, `roomnum`, `introduction`, `businesslicensefront`, `businesslicenseback`, `hotelpms`, `isvisible`, `isonline`, `idcardfront`, `idcardback`, `retentiontime`, `defaultleavetime`, `hotelphone`, `hoteltype`, `discode`, `qtphone`, `citycode`, `provcode`, `pmstype`) VALUES ('410', '万鑫全时尚宾馆', '翁老板', '2015-03-30 12:28:10', '川黄路191号', '0.00000000', '0.00000000', '2013-02-01 00:00:01', '2013-02-01 00:00:01', '43', '\"上海万鑫全时尚宾馆位于上海市迪斯尼板块川沙镇，步行即可达川沙古镇。上海万鑫全时尚宾馆是一家集创意、设计、装饰、培训为一体的主题概念酒店，坚持“个性与原创、舒适与环保”的设计理念，以时尚、前卫为主题，定位于休闲、都市、潮流。宾馆房间设计新颖，线条简练，更配备有空调、电视等，为您旅游休闲提供便利的住宿体验\"', 'https://dn-imke-pro.qbox.me/FnYB1nVDMl-AJ81pNeOgLs9exfk0', '', '2zCMvWZL9bIWgvq5MZ8pv3', 'T', 'T', '', '', '200000', '120000', '021-50965796', NULL, '310115', '', '310000', '310000', NULL)";
    	jdbcTemplate.update(sql);
    	String pms = "2zCMvWZL9bIWgvq5MZ8pv3";
    	HotelModel vo = hotelServiceImpl.queryByPms(pms);
    	Assert.assertNotNull(vo);
    	Assert.assertEquals(vo.getHotelname().equals("万鑫全时尚宾馆"),true);
    }

    
}
