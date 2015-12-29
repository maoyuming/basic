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

import com.fangbaba.basic.face.bean.HotelModel;
import com.fangbaba.basic.face.bean.RoomtypeModel;
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
    
}
