package com.duantuke.basic.mappers;

import com.duantuke.basic.po.HotelRTag;
import com.duantuke.basic.po.HotelRTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HotelRTagMapper {
    int countByExample(HotelRTagExample example);

    int deleteByExample(HotelRTagExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HotelRTag record);

    int insertSelective(HotelRTag record);

    List<HotelRTag> selectByExample(HotelRTagExample example);

    HotelRTag selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HotelRTag record, @Param("example") HotelRTagExample example);

    int updateByExample(@Param("record") HotelRTag record, @Param("example") HotelRTagExample example);

    int updateByPrimaryKeySelective(HotelRTag record);

    int updateByPrimaryKey(HotelRTag record);
}