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

import com.fangbaba.basic.face.bean.GdsChannel;
import com.fangbaba.basic.face.bean.GdsType;
import com.fangbaba.basic.service.impl.GdsChannelServiceImpl;
import com.fangbaba.basic.service.impl.GdsTypeServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext*.xml" })
public class GdsChannelServiceTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	private GdsChannelServiceImpl gdsChannelServiceImpl;
	
	@Before
    public void before(){
        String sql = "delete from gds_channel";
        jdbcTemplate.update(sql);
    
    }
    @Test
    public void testSave(){
    	GdsChannel gdsType = new GdsChannel();
    	gdsType.setChannelid(111);
    	gdsType.setCreatetime(new Date());
    	gdsType.setName("rtestset");
    	gdsType.setState(1);
    	gdsType.setUpdatetime(new Date());
    	Integer count = gdsChannelServiceImpl.save(gdsType);
    	
    	Assert.assertNotNull(count);
    	Assert.assertEquals(count>0,true);
    }

}
