package com.fangbaba.basic.mappers;

import com.fangbaba.basic.po.OtaHotel;
import com.fangbaba.basic.po.OtaHotelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OtaHotelMapper {
    int countByExample(OtaHotelExample example);

    int deleteByExample(OtaHotelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OtaHotel record);

    int insertSelective(OtaHotel record);

    List<OtaHotel> selectByExample(OtaHotelExample example);

    OtaHotel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OtaHotel record, @Param("example") OtaHotelExample example);

    int updateByExample(@Param("record") OtaHotel record, @Param("example") OtaHotelExample example);

    int updateByPrimaryKeySelective(OtaHotel record);

    int updateByPrimaryKey(OtaHotel record);
}