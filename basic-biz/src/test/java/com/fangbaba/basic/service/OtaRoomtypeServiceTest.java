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
import com.fangbaba.basic.face.bean.OtaRoomtype;
import com.fangbaba.basic.face.enums.OtaDeployStatusEnum;
import com.fangbaba.basic.service.impl.OtaRoomtypeServiceImpl;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext*.xml" })
public class OtaRoomtypeServiceTest extends AbstractTransactionalJUnit4SpringContextTests{

    @Autowired
    private OtaRoomtypeServiceImpl otaRoomtypeServiceImpl;
    
    
    @Before
    public void before(){

        String sql = "delete from ota_roomtype";
        jdbcTemplate.update(sql);
    
    }
    @Test
	public  void testQueryWaitDeploy() {
    	String sql = "INSERT INTO `ota_roomtype` (`id`, `hotelid`, `roomtypeid`, `isdeploy`, `otatype`, `num`, `createtime`, `createuser`, `updatetime`, `updateuser`) "
    			+ "VALUES ('1', '1', '1', '1', '1', '1', NULL, NULL, NULL, NULL);";
    	jdbcTemplate.update(sql);
    	List<OtaRoomtype> list =  otaRoomtypeServiceImpl.queryOtaRoomtypeByDeploy(OtaDeployStatusEnum.un);

		Assert.assertNotNull(list);
		Assert.assertEquals(list.size()==1,true);
		
		
		for (OtaRoomtype otaRoomtype : list) {
			Assert.assertEquals(otaRoomtype.getIsdeploy()==1,true);
		}
		
    }
}
