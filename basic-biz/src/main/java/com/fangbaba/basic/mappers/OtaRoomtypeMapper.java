package com.fangbaba.basic.mappers;

import com.fangbaba.basic.po.OtaRoomtype;
import com.fangbaba.basic.po.OtaRoomtypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OtaRoomtypeMapper {
    int countByExample(OtaRoomtypeExample example);

    int deleteByExample(OtaRoomtypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OtaRoomtype record);

    int insertSelective(OtaRoomtype record);

    List<OtaRoomtype> selectByExample(OtaRoomtypeExample example);

    OtaRoomtype selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OtaRoomtype record, @Param("example") OtaRoomtypeExample example);

    int updateByExample(@Param("record") OtaRoomtype record, @Param("example") OtaRoomtypeExample example);

    int updateByPrimaryKeySelective(OtaRoomtype record);

    int updateByPrimaryKey(OtaRoomtype record);
}