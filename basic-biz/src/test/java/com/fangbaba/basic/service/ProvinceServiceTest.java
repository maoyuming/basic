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

import com.fangbaba.basic.face.bean.ProvinceModel;
import com.fangbaba.basic.service.impl.ProvinceServiceImpl;

/**
 * @author he
 * 城市相关接口
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext*.xml" })
public class ProvinceServiceTest extends AbstractTransactionalJUnit4SpringContextTests{
    @Autowired
    private ProvinceServiceImpl provinceServiceImpl;
    @Before
    public void before(){
        String sql = "delete from province";
        jdbcTemplate.update(sql);
    
    }
    @Test
    public void testQueryAllProvinces(){
    	String sql = "INSERT INTO `province` (`id`, `code`, `name`, `sort`, `remark`, `latitude`, `longitude`) VALUES ('61', '110000', 'B 北京市', '1', '', '39.90817260', '116.39794710');";
    	jdbcTemplate.update(sql);
    	List<ProvinceModel> list = provinceServiceImpl.queryAllProvinces();

		Assert.assertNotNull(list);
		Assert.assertEquals(list.size()==1,true);
    }
}
