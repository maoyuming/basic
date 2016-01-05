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

import com.fangbaba.basic.face.bean.OtaHotel;
import com.fangbaba.basic.service.impl.OtaHotelServiceImpl;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext*.xml" })
public class OtaHotelServiceTest extends AbstractTransactionalJUnit4SpringContextTests{

    @Autowired
    private OtaHotelServiceImpl otaHotelServiceImpl;
    
    
    @Before
    public void before(){

        String sql = "delete from ota_hotel";
        jdbcTemplate.update(sql);
    
    }
    @Test
	public  void testQueryWaitDeploy() {
    	String sql = "INSERT INTO `ota_hotel` (`id`, `hotelid`, `isdeploy`, `otatype`, `createtime`, `createuser`, `updatetime`, `updateuser`) "
    			+ "VALUES ('1', '11', '1', '1', NULL, NULL, NULL, NULL);";
    	jdbcTemplate.update(sql);
    	List<OtaHotel> list =  otaHotelServiceImpl.queryWaitDeploy();

		Assert.assertNotNull(list);
		Assert.assertEquals(list.size()==1,true);
		
		
		for (OtaHotel otaHotel : list) {
			Assert.assertEquals(otaHotel.getIsdeploy()==1,true);
		}
		
    }
}
