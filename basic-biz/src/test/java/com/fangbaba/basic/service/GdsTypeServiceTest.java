package com.fangbaba.basic.service;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fangbaba.basic.face.bean.GdsType;
import com.fangbaba.basic.service.impl.GdsTypeServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext*.xml" })
public class GdsTypeServiceTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	private GdsTypeServiceImpl gdsTypeService;
	
	@Before
    public void before(){
        String sql = "delete from gds_type";
        jdbcTemplate.update(sql);
    
    }
    @Test
    public void testQueryGdsTypeByOtatype(){
    	String sql = "INSERT INTO `gds_type` (`id`, `otatype`, `name`, `state`, `channelid`, `createtime`, `createuser`, `updatetime`, `updateuser`) VALUES ('187', '1', '11', '1', '11', '2016-01-18 17:32:41', '', '2016-01-18 17:32:45', NULL);";
    	jdbcTemplate.update(sql);
    	Integer otatype= 1;
    	GdsType gdsType = gdsTypeService.queryGdsTypeByOtatype(otatype);

		Assert.assertNotNull(gdsType);
		Assert.assertEquals(gdsType.getState() ==1,true);
    }
    @Test
    public void testQueryGdsTypeByChannelid(){
    	String sql = "INSERT INTO `gds_type` (`id`, `otatype`, `name`, `state`, `channelid`, `createtime`, `createuser`, `updatetime`, `updateuser`) VALUES ('187', '1', '11', '1', '11', '2016-01-18 17:32:41', '', '2016-01-18 17:32:45', NULL);";
    	jdbcTemplate.update(sql);
    	Integer channelid= 11;
    	List<GdsType> gdsType = gdsTypeService.queryGdsTypeByChannelid(channelid);
    	
    	Assert.assertNotNull(gdsType);
    	Assert.assertEquals(gdsType.size() ==1,true);
    }
    @Test
    public void testSave(){
    	GdsType gdsType = new GdsType();
    	gdsType.setChannelid(111);
    	gdsType.setCreatetime(new Date());
    	gdsType.setName("rtestset");
    	gdsType.setOtatype(1);
    	gdsType.setState(1);
    	gdsType.setUpdatetime(new Date());
    	Integer count = gdsTypeService.save(gdsType);
    	
    	Assert.assertNotNull(count);
    	Assert.assertEquals(count>0,true);
    }

}
