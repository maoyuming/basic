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
    
    @Test
   	public  void testUpdateStatus() {
       	String sql = "INSERT INTO `ota_roomtype` (`id`, `hotelid`, `roomtypeid`, `isdeploy`, `otatype`, `num`, `createtime`, `createuser`, `updatetime`, `updateuser`) "
       			+ "VALUES ('1', '1', '1', '1', '1', '1', NULL, NULL, NULL, NULL);";
       	jdbcTemplate.update(sql);
       	
       	OtaRoomtype otaRoomtype=new OtaRoomtype();
       	otaRoomtype.setId(1L);
       	otaRoomtype.setHotelid(1L);
       	otaRoomtype.setRoomtypeid(1L);
       	otaRoomtype.setIsdeploy(OtaDeployStatusEnum.fail.getId());
       	otaRoomtype.setNum(1);
       	otaRoomtype.setOtatype(1);
       	Integer result=  otaRoomtypeServiceImpl.updateOtaRoomtype(otaRoomtype);

       	Assert.assertEquals(result==1, true);
       	
       	
       }
    
    @Test
    public void testGetOtaRoomtypeByRoomtype(){
    	String sql = "INSERT INTO `ota_roomtype` (`id`, `hotelid`, `roomtypeid`, `isdeploy`, `otatype`, `num`, `createtime`, `createuser`, `updatetime`, `updateuser`) "
       			+ "VALUES ('1', '1', '1', '1', '1', '1', NULL, NULL, NULL, NULL);";
       	jdbcTemplate.update(sql);
       	
    	OtaRoomtype otaRoomtype=otaRoomtypeServiceImpl.getOtaRoomtypeByOtaRoomtype(1L, 1L, 1);
    	Assert.assertNotNull(otaRoomtype);
    }
    
    @Test
    public void testUpdateOtaRoomNoNull(){
    	String sql1 = "INSERT INTO `room` (`id`,`roomtypeid`,`roomno`,`roompms`,`tel`,`remark`) VALUES(1,1,'no1','pms1','tel01','remark1') ;";
    	jdbcTemplate.update(sql1);
    	String sql2 = "INSERT INTO `room` (`id`,`roomtypeid`,`roomno`,`roompms`,`tel`,`remark`) VALUES(2,1,'no2','pms2','tel02','remark2') ;";
    	jdbcTemplate.update(sql2);
    	
    	Integer result=otaRoomtypeServiceImpl.updateOtaRoomNo(1L, 1L, 1, 2);
       	
       	Assert.assertTrue(result==1);
    	
       	
       	com.fangbaba.basic.po.OtaRoomtype otaRoomtype=otaRoomtypeServiceImpl.getOtaRoomtypeByRoomtype(1L, 1L, 1);
       	Assert.assertNotNull(otaRoomtype);
       	Assert.assertTrue(otaRoomtype.getNum()==2);
    }
    
    @Test
    public void testUpdateOtaRoomNoBig(){
    	String sql1 = "INSERT INTO `room` (`id`,`roomtypeid`,`roomno`,`roompms`,`tel`,`remark`) VALUES(1,1,'no1','pms1','tel01','remark1') ;";
    	jdbcTemplate.update(sql1);
    	String sql2 = "INSERT INTO `room` (`id`,`roomtypeid`,`roomno`,`roompms`,`tel`,`remark`) VALUES(2,1,'no2','pms2','tel02','remark2') ;";
    	jdbcTemplate.update(sql2);
    	
    	Integer result=otaRoomtypeServiceImpl.updateOtaRoomNo(1L, 1L, 1, 200);
       	
       	Assert.assertTrue(result==0);
    	
    }
    
    @Test
    public void testUpdateOtaRoomNoRoomEmpty(){
    	
    	Integer result=otaRoomtypeServiceImpl.updateOtaRoomNo(1L, 1L, 1, 200);
       	
       	Assert.assertTrue(result==0);
    	
    }
    
    @Test
    public void testUpdateOtaRoomNo(){
    	String sql1 = "INSERT INTO `room` (`id`,`roomtypeid`,`roomno`,`roompms`,`tel`,`remark`) VALUES(1,1,'no1','pms1','tel01','remark1') ;";
    	jdbcTemplate.update(sql1);
    	String sql2 = "INSERT INTO `room` (`id`,`roomtypeid`,`roomno`,`roompms`,`tel`,`remark`) VALUES(2,1,'no2','pms2','tel02','remark2') ;";
    	jdbcTemplate.update(sql2);
    	
    	String sql = "INSERT INTO `ota_roomtype` (`id`, `hotelid`, `roomtypeid`, `isdeploy`, `otatype`, `num`, `createtime`, `createuser`, `updatetime`, `updateuser`) "
       			+ "VALUES ('1', '1', '1', '1', '1', '1', NULL, NULL, NULL, NULL);";
       	jdbcTemplate.update(sql);
    	
    	Integer result=otaRoomtypeServiceImpl.updateOtaRoomNo(1L, 1L, 1, 2);
       	
       	Assert.assertTrue(result==1);
       	
       	com.fangbaba.basic.po.OtaRoomtype otaRoomtype=otaRoomtypeServiceImpl.getOtaRoomtypeByRoomtype(1L, 1L, 1);
       	Assert.assertNotNull(otaRoomtype);
       	Assert.assertTrue(otaRoomtype.getNum()==2);
    }
}
