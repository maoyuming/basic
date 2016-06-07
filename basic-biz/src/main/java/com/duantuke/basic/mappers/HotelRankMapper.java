package com.duantuke.basic.mappers;

import com.duantuke.basic.po.HotelRank;
import com.duantuke.basic.po.HotelRankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HotelRankMapper {
    int countByExample(HotelRankExample example);

    int deleteByExample(HotelRankExample example);

    int deleteByPrimaryKey(Long hotelRankId);

    int insert(HotelRank record);

    int insertSelective(HotelRank record);

    List<HotelRank> selectByExample(HotelRankExample example);

    HotelRank selectByPrimaryKey(Long hotelRankId);

    int updateByExampleSelective(@Param("record") HotelRank record, @Param("example") HotelRankExample example);

    int updateByExample(@Param("record") HotelRank record, @Param("example") HotelRankExample example);

    int updateByPrimaryKeySelective(HotelRank record);

    int updateByPrimaryKey(HotelRank record);
}