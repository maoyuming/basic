package com.fangbaba.basic.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fangbaba.basic.face.bean.CityModel;
import com.fangbaba.basic.po.CityModelExample;

public interface CityModelMapper {
    int countByExample(CityModelExample example);

    int deleteByExample(CityModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CityModel record);

    int insertSelective(CityModel record);

    List<CityModel> selectByExample(CityModelExample example);

    CityModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CityModel record, @Param("example") CityModelExample example);

    int updateByExample(@Param("record") CityModel record, @Param("example") CityModelExample example);

    int updateByPrimaryKeySelective(CityModel record);

    int updateByPrimaryKey(CityModel record);
}