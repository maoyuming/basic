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
import com.fangbaba.basic.service.impl.HotelServiceImpl;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext*.xml" })
public class HotelServiceTest extends AbstractTransactionalJUnit4SpringContextTests{

    @Autowired
    private HotelServiceImpl hotelServiceImpl;
    
    
    /*@Before
    public void before(){

        String sql = "delete from hotel";
        jdbcTemplate.update(sql);
    
    }*/
   /* @Test
	public  void testQueryAllHotels() {
    	String sql = "INSERT INTO `hotel` VALUES (399, '上轩商务酒店', '上轩商务', '2015-3-26 17:12:27', '天津市和平区', 117.19590800, 39.11832800, '2014-1-28 00:00:00', '2014-2-11 00:00:00', 68, '性价比高，住宿环境、通风采光较好。', 'https://dn-imke-pro.qbox.me/FmalZsisRpZVQMWKauH3vDFJDmub', '', '3ZyeYNlYZ6LEhi6WWak123', 'T', 'T', '', '', '180000', '120000', '021-56792199', 2, 500101, '010-8189001', 500000, 500000, NULL);";
    	jdbcTemplate.update(sql);
    	 
    	List<HotelModel> list =  hotelServiceImpl.queryAllHotels();
    	

		Assert.assertNotNull(list);
		Assert.assertEquals(list.size()==1,true);
		
    }*/
   /* @Test
	public void testQueryById() {
    	String sql = "INSERT INTO `hotel` VALUES (399, '上轩商务酒店', '上轩商务', '2015-3-26 17:12:27', '天津市和平区', 117.19590800, 39.11832800, '2014-1-28 00:00:00', '2014-2-11 00:00:00', 68, '性价比高，住宿环境、通风采光较好。', 'https://dn-imke-pro.qbox.me/FmalZsisRpZVQMWKauH3vDFJDmub', '', '3ZyeYNlYZ6LEhi6WWak123', 'T', 'T', '', '', '180000', '120000', '021-56792199', 2, 500101, '010-8189001', 500000, 500000, NULL);";
    	jdbcTemplate.update(sql);
    	 
    	HotelModel hotelModel =  hotelServiceImpl.queryById(399L);    	

		Assert.assertNotNull(hotelModel);
		Assert.assertEquals(hotelModel.getHotelname().equals("上轩商务酒店"),true);
	}*/

    @Test
    @Rollback(false)
    public void testSyncHotelInfo(){
    	String json = "{\"pmstypeid\":1,\"hotelid\":\"xxxx\",\"phone\":18600210340,\"roomtypes\":[{\"id\":\"0TIH30Ma52eWwvErie0JkI\",\"name\":\"hehe\",\"price\":\"300\",\"rooms\":[{\"id\":\"2eiNyEOzhaCXOXIPXMMmJCG\",\"roomno\":\"1111\"}]},{\"id\":\"174We7hIxdaV8mRg5aN31qj\",\"name\":\"nimei\",\"price\":\"299\",\"rooms\":[{\"id\":\"1eLf2qEBdeeXtBy1aOgXzx\",\"roomno\":\"2222\"}]}]}";
    	hotelServiceImpl.syncHotelInfo(json);
    	
    	List<HotelModel> list =  hotelServiceImpl.queryAllHotels();
		Assert.assertNotNull(list);
		Assert.assertEquals(list.size()>0,true);
    }

    
}
