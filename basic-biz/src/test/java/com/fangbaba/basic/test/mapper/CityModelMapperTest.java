package com.fangbaba.basic.test.mapper;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fangbaba.basic.face.bean.CityModel;
import com.fangbaba.basic.mappers.CityModelMapper;


/**

 * 类命名规则：对某个mapper单元测试  XXXMapper+Test命名
 * 
 * @author tankai
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext*.xml" })
public class CityModelMapperTest extends AbstractTransactionalJUnit4SpringContextTests{

	/**
	 * 自动注入mapper
	 */
	@Autowired
	CityModelMapper cityModelMapper;

	/**
	 * 单元测试开始前清理数据
	 */
    @Before
    public void before(){
        String sql = "delete from city";
        jdbcTemplate.update(sql);
    }
    
	
    /**
     * 开始单元测试
     */
	@Test
	public void testInsert(){
		
		CityModel record = new CityModel();
		record.setId(1L);
		record.setCode("11111");
		record.setLatitude(new BigDecimal(51));
		record.setLongitude(new BigDecimal(11));
		record.setName("城市");
		record.setProid(1111);
		record.setQuerycityname("sssss");
		int count = cityModelMapper.insertSelective(record);
		
		//断言
		Assert.assertEquals(count>=1,true);
		
	}
	@Test
	public void testQuery(){
		//模拟录入数据
		String sql = "INSERT INTO `city` (id,code,name,proid,sort,latitude,longitude,simplename,ishotcity,`range`,isselect,querycityname)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
        jdbcTemplate.update(sql,1,1111,3,4,51,61,71,81,91,101,11,12);
        jdbcTemplate.update(sql,2,122,1,1,1,1,1,1,1,1,1,1);
        jdbcTemplate.update(sql,3,133,1,1,1,1,1,1,1,1,1,1);
        jdbcTemplate.update(sql,4,144,1,1,1,1,1,1,1,1,1,1);
        CityModel cityModel = cityModelMapper.selectByPrimaryKey(2L);
		
        
        //断言
		Assert.assertEquals(cityModel.getCode().equals("122"),true);
	}

}