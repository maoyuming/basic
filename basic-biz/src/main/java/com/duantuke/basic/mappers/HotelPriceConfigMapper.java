package com.duantuke.basic.mappers;

import com.duantuke.basic.po.HotelPriceConfig;
import com.duantuke.basic.po.HotelPriceConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HotelPriceConfigMapper {
    int countByExample(HotelPriceConfigExample example);

    int deleteByExample(HotelPriceConfigExample example);

    int deleteByPrimaryKey(Long hotelPriceConfigId);

    int insert(HotelPriceConfig record);

    int insertSelective(HotelPriceConfig record);

    List<HotelPriceConfig> selectByExample(HotelPriceConfigExample example);

    HotelPriceConfig selectByPrimaryKey(Long hotelPriceConfigId);

    int updateByExampleSelective(@Param("record") HotelPriceConfig record, @Param("example") HotelPriceConfigExample example);

    int updateByExample(@Param("record") HotelPriceConfig record, @Param("example") HotelPriceConfigExample example);

    int updateByPrimaryKeySelective(HotelPriceConfig record);

    int updateByPrimaryKey(HotelPriceConfig record);
}