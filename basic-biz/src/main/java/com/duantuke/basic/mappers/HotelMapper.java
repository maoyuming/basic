package com.duantuke.basic.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.duantuke.basic.esbean.input.HotelInputBean;
import com.duantuke.basic.po.Hotel;
import com.duantuke.basic.po.HotelExample;

public interface HotelMapper {
    int countByExample(HotelExample example);

    int deleteByExample(HotelExample example);

    int deleteByPrimaryKey(Long hotelId);

    int insert(Hotel record);

    int insertSelective(Hotel record);

    List<Hotel> selectByExampleWithBLOBs(HotelExample example);

    List<Hotel> selectByExample(HotelExample example);

    Hotel selectByPrimaryKey(Long hotelId);

    int updateByExampleSelective(@Param("record") Hotel record, @Param("example") HotelExample example);

    int updateByExampleWithBLOBs(@Param("record") Hotel record, @Param("example") HotelExample example);

    int updateByExample(@Param("record") Hotel record, @Param("example") HotelExample example);

    int updateByPrimaryKeySelective(Hotel record);

    int updateByPrimaryKeyWithBLOBs(Hotel record);

    int updateByPrimaryKey(Hotel record);
    
    List<HotelInputBean> queryEsInputHotels(@Param("hotelId") Long hotelId);

}