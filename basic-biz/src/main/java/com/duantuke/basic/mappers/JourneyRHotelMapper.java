package com.duantuke.basic.mappers;

import com.duantuke.basic.po.JourneyRHotel;
import com.duantuke.basic.po.JourneyRHotelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JourneyRHotelMapper {
    int countByExample(JourneyRHotelExample example);

    int deleteByExample(JourneyRHotelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JourneyRHotel record);

    int insertSelective(JourneyRHotel record);

    List<JourneyRHotel> selectByExample(JourneyRHotelExample example);

    JourneyRHotel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JourneyRHotel record, @Param("example") JourneyRHotelExample example);

    int updateByExample(@Param("record") JourneyRHotel record, @Param("example") JourneyRHotelExample example);

    int updateByPrimaryKeySelective(JourneyRHotel record);

    int updateByPrimaryKey(JourneyRHotel record);
}