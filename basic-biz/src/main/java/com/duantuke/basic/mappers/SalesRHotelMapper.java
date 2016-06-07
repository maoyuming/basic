package com.duantuke.basic.mappers;

import com.duantuke.basic.po.SalesRHotel;
import com.duantuke.basic.po.SalesRHotelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesRHotelMapper {
    int countByExample(SalesRHotelExample example);

    int deleteByExample(SalesRHotelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SalesRHotel record);

    int insertSelective(SalesRHotel record);

    List<SalesRHotel> selectByExample(SalesRHotelExample example);

    SalesRHotel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SalesRHotel record, @Param("example") SalesRHotelExample example);

    int updateByExample(@Param("record") SalesRHotel record, @Param("example") SalesRHotelExample example);

    int updateByPrimaryKeySelective(SalesRHotel record);

    int updateByPrimaryKey(SalesRHotel record);
}