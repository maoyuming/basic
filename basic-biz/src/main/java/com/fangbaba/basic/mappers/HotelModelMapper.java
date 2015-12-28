package com.fangbaba.basic.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.fangbaba.basic.po.HotelModel;
import com.fangbaba.basic.po.HotelModelExample;

public interface HotelModelMapper {
    int countByExample(HotelModelExample example);

    int deleteByExample(HotelModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HotelModel record);

    int insertSelective(HotelModel record);

    List<HotelModel> selectByExampleWithBLOBs(HotelModelExample example);

    List<HotelModel> selectByExample(HotelModelExample example);

    HotelModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HotelModel record, @Param("example") HotelModelExample example);

    int updateByExampleWithBLOBs(@Param("record") HotelModel record, @Param("example") HotelModelExample example);

    int updateByExample(@Param("record") HotelModel record, @Param("example") HotelModelExample example);

    int updateByPrimaryKeySelective(HotelModel record);

    int updateByPrimaryKeyWithBLOBs(HotelModel record);

    int updateByPrimaryKey(HotelModel record);
}