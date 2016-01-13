package com.fangbaba.basic.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fangbaba.basic.face.bean.HotelSaleConfig;
import com.fangbaba.basic.po.HotelSaleConfigExample;

public interface HotelSaleConfigMapper {
    int countByExample(HotelSaleConfigExample example);

    int deleteByExample(HotelSaleConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HotelSaleConfig record);

    int insertSelective(HotelSaleConfig record);

    List<HotelSaleConfig> selectByExample(HotelSaleConfigExample example);

    HotelSaleConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HotelSaleConfig record, @Param("example") HotelSaleConfigExample example);

    int updateByExample(@Param("record") HotelSaleConfig record, @Param("example") HotelSaleConfigExample example);

    int updateByPrimaryKeySelective(HotelSaleConfig record);

    int updateByPrimaryKey(HotelSaleConfig record);
}