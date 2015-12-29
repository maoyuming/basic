package com.fangbaba.basic.service;

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
    
}
