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

import com.fangbaba.basic.face.bean.CityModel;
import com.fangbaba.basic.service.impl.CityServiceImpl;

/**
 * @author he
 * 城市相关接口
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext*.xml" })
public class CityServiceTest extends AbstractTransactionalJUnit4SpringContextTests{
    @Autowired
    private CityServiceImpl cityServiceImpl;
    @Before
    public void before(){
        String sql = "delete from city";
        jdbcTemplate.update(sql);
    
    }
    @Test
    public void testQueryAllCitys(){
    	String sql = "INSERT INTO  `city` (`id`, `code`, `name`, `proid`, `sort`, `latitude`, `longitude`, `simplename`, `ishotcity`, `range`, `isselect`, `querycityname`) VALUES ('391', '110000', 'B 北京市', '61', '1', '39.90817260', '116.39794710', '', 'F', NULL, 'F', '北京市');";
    	jdbcTemplate.update(sql);
    	List<CityModel> list = cityServiceImpl.queryAllCitys();

		Assert.assertNotNull(list);
		Assert.assertEquals(list.size()==1,true);
    }
}
