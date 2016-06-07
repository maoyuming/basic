package com.duantuke.basic.mappers;

import com.duantuke.basic.po.BossesRHotel;
import com.duantuke.basic.po.BossesRHotelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BossesRHotelMapper {
    int countByExample(BossesRHotelExample example);

    int deleteByExample(BossesRHotelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BossesRHotel record);

    int insertSelective(BossesRHotel record);

    List<BossesRHotel> selectByExample(BossesRHotelExample example);

    BossesRHotel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BossesRHotel record, @Param("example") BossesRHotelExample example);

    int updateByExample(@Param("record") BossesRHotel record, @Param("example") BossesRHotelExample example);

    int updateByPrimaryKeySelective(BossesRHotel record);

    int updateByPrimaryKey(BossesRHotel record);
}