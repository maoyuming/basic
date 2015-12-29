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
import com.fangbaba.basic.face.bean.DistrictModel;
import com.fangbaba.basic.service.impl.DistrictServiceImpl;

/**
 * @author he
 * 城市相关接口
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext*.xml" })
public class DistrictServiceTest extends AbstractTransactionalJUnit4SpringContextTests{
    @Autowired
    private DistrictServiceImpl districtServiceImpl;
    @Before
    public void before(){
        String sql = "delete from district";
        jdbcTemplate.update(sql);
    
    }
    @Test
    public void testQueryAllDistricts(){
    	String sql = "INSERT INTO `district` (`id`, `code`, `name`, `cityid`, `sort`, `latitude`, `longitude`) VALUES ('3195', '110101', 'D 东城区', '391', '1', '39.93511990', '116.40939470');";
    	jdbcTemplate.update(sql);
    	List<DistrictModel> list = districtServiceImpl.queryAllDistricts();

		Assert.assertNotNull(list);
		Assert.assertEquals(list.size()==1,true);
    }
}
