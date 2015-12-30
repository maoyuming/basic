package com.fangbaba.basic.service;

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
import com.fangbaba.basic.face.bean.jsonbean.PmsRoomJsonBean;
import com.fangbaba.basic.service.impl.RoomServiceImpl;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext*.xml" })
public class RoomServiceTest extends AbstractTransactionalJUnit4SpringContextTests{

    @Autowired
    private RoomServiceImpl roomServiceImpl;
    
    
    @Before
    public void before(){

        String sql = "delete from room";
        jdbcTemplate.update(sql);
    
    }
    @Test
	public  void testQueryByRoomTypeId() {
    	String sql = "INSERT INTO `room` (`id`,`roomtypeid`,`roomno`,`roompms`,`tel`,`remark`) VALUES(1,1,'no1','pms1','tel01','remark1') ;";
    	jdbcTemplate.update(sql);
    	 
    	List<RoomModel> list =  roomServiceImpl.queryByRoomTypeId(1L);

		Assert.assertNotNull(list);
		Assert.assertEquals(list.size()==1,true);
		
    }
    @Test
	public  void testQueryByPms() {
    	String sql = "INSERT INTO `room` (`id`,`roomtypeid`,`roomno`,`roompms`,`tel`,`remark`) VALUES(1,1,'no1','pms1','tel01','remark1') ;";
    	jdbcTemplate.update(sql);
    	 
    	RoomModel roomModel =  roomServiceImpl.queryByPms("pms1");

		Assert.assertNotNull(roomModel);
    	
    }
    @Test
    public  void testQueryById() {
    	String sql = "INSERT INTO `room` (`id`,`roomtypeid`,`roomno`,`roompms`,`tel`,`remark`) VALUES(1,1,'no1','pms1','tel01','remark1') ;";
    	jdbcTemplate.update(sql);
    	 
    	RoomModel roomModel =  roomServiceImpl.queryById(1l);

		Assert.assertNotNull(roomModel);
    }
    @Test
    public  void testSyncRoomInfo() {
    	String sql = "INSERT INTO `room` (`id`,`roomtypeid`,`roomno`,`roompms`,`tel`,`remark`) VALUES(1,1,'no1','pms1','tel01','remark1') ;";
    	String sql2 = "INSERT INTO `room` (`id`,`roomtypeid`,`roomno`,`roompms`,`tel`,`remark`) VALUES(2,1,'no2','pms2','tel02','remark2') ;";
    	String sql3 = "INSERT INTO `room` (`id`,`roomtypeid`,`roomno`,`roompms`,`tel`,`remark`) VALUES(3,1,'no3','pms3','tel03','remark3') ;";
    	jdbcTemplate.update(sql);
    	jdbcTemplate.update(sql2);
    	jdbcTemplate.update(sql3);
    	List<PmsRoomJsonBean> rooms = new ArrayList<PmsRoomJsonBean>();
    	List<RoomModel> list =  roomServiceImpl.queryByRoomTypeId(1L);
    	for (RoomModel roomModel:list) {
    		PmsRoomJsonBean pmsRoomJsonBean = new PmsRoomJsonBean();
    		pmsRoomJsonBean.setId(roomModel.getId().toString());
    		pmsRoomJsonBean.setRoomno("kkkk");
    		rooms.add(pmsRoomJsonBean);
		}
    	roomServiceImpl.syncRoomInfo(1l, rooms);
    	List<RoomModel> list1 =  roomServiceImpl.queryByRoomTypeId(1L);
    	Assert.assertEquals((list1.get(0).getRoomno()).equals("kkkk"),true);
    	
    }
    @Test
    public  void testDelRoomByRoomtypeid() {
    	String sql = "INSERT INTO `room` (`id`,`roomtypeid`,`roomno`,`roompms`,`tel`,`remark`) VALUES(1,1,'no1','pms1','tel01','remark1') ;";
    	jdbcTemplate.update(sql);
    	 
    	roomServiceImpl.delRoomByRoomtypeid(1l);

    	List<RoomModel> list =  roomServiceImpl.queryByRoomTypeId(1L);

		Assert.assertNotNull(list);
		Assert.assertEquals(list.size()==0,true);
    	
    }
    
}
