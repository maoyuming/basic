package com.fangbaba.basic.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fangbaba.basic.face.bean.RoomModel;
import com.fangbaba.basic.face.bean.RoomtypeModel;
import com.fangbaba.basic.face.bean.jsonbean.PmsRoomJsonBean;
import com.fangbaba.basic.face.bean.jsonbean.PmsRoomtypeJsonBean;
import com.fangbaba.basic.service.impl.RoomtypeServiceImpl;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext*.xml" })
public class RoomTypeServiceTest extends AbstractTransactionalJUnit4SpringContextTests{

    @Autowired
    private RoomtypeServiceImpl roomtypeServiceImpl;
    
    
    @Before
    public void before(){

        String sql = "delete from roomtype";
        jdbcTemplate.update(sql);
    
    }
    @Test
	public  void testQueryByHotelId() {
    	String sql = "INSERT INTO `roomtype`  VALUES (1, 1, 'type1', 'pms1', 5, 117);";
    	jdbcTemplate.update(sql);
    	List<RoomtypeModel> list =  roomtypeServiceImpl.queryByHotelId(1L);

		Assert.assertNotNull(list);
		Assert.assertEquals(list.size()==1,true);
		
    }
    @Test
	public  void testQueryPriceByRoomTypeId() {
    	String sql = "INSERT INTO `roomtype`  VALUES (1, 1, 'type1', 'pms1', 5, 117);";
    	jdbcTemplate.update(sql);
    	BigDecimal price =  roomtypeServiceImpl.queryPriceByRoomTypeId(1L);

		Assert.assertNotNull(price);
    }
    @Test
    public  void testQueryById() {
    	String sql = "INSERT INTO `roomtype`  VALUES (1, 1, 'type1', 'pms1', 5, 117);";
    	jdbcTemplate.update(sql);
    	RoomtypeModel bean =  roomtypeServiceImpl.queryById(1L);

		Assert.assertNotNull(bean);
    }
    @Test
    public  void testQueryByPms() {
    	String sql = "INSERT INTO `roomtype`  VALUES (1, 1, 'type1', 'pms1', 5, 117);";
    	jdbcTemplate.update(sql);
    	RoomtypeModel bean =  roomtypeServiceImpl.queryByPms("pms1");

		Assert.assertNotNull(bean);
    }
    @Test
    public  void testSyncRoomtypeInfo() {
    	String sql = "INSERT INTO `roomtype`  VALUES (1, 1, 'type1', 'pms1', 5, 117);";
    	String sql2 = "INSERT INTO `roomtype`  VALUES (2, 1, 'type2', 'pms2', 6, 118);";
    	String sql3 = "INSERT INTO `roomtype`  VALUES (3, 1, 'type3', 'pms3', 7, 119);";
    	jdbcTemplate.update(sql);
    	jdbcTemplate.update(sql2);
    	jdbcTemplate.update(sql3);
    	List<PmsRoomtypeJsonBean> roomtypes = new ArrayList<PmsRoomtypeJsonBean>();
    	List<RoomtypeModel> list =  roomtypeServiceImpl.queryByHotelId(1l);
    	for (RoomtypeModel roomtypeModel:list) {
    		PmsRoomtypeJsonBean pmsRoomtypeJsonBean = new PmsRoomtypeJsonBean();
    		pmsRoomtypeJsonBean.setId(roomtypeModel.getId().toString());
    		pmsRoomtypeJsonBean.setName("kkkk");
    		pmsRoomtypeJsonBean.setPrice("21");
    		roomtypes.add(pmsRoomtypeJsonBean);
		}
    	roomtypeServiceImpl.syncRoomtypeInfo(1l, roomtypes);
    	List<RoomtypeModel> list1 =  roomtypeServiceImpl.queryByHotelId(1l);
    	Assert.assertEquals((list1.get(0).getName()).equals("kkkk"),true);
    }
}
