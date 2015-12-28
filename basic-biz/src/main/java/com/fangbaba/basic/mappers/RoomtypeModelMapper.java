package com.fangbaba.basic.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fangbaba.basic.face.bean.RoomtypeModel;
import com.fangbaba.basic.po.RoomtypeModelExample;

public interface RoomtypeModelMapper {
    int countByExample(RoomtypeModelExample example);

    int deleteByExample(RoomtypeModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoomtypeModel record);

    int insertSelective(RoomtypeModel record);

    List<RoomtypeModel> selectByExample(RoomtypeModelExample example);

    RoomtypeModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RoomtypeModel record, @Param("example") RoomtypeModelExample example);

    int updateByExample(@Param("record") RoomtypeModel record, @Param("example") RoomtypeModelExample example);

    int updateByPrimaryKeySelective(RoomtypeModel record);

    int updateByPrimaryKey(RoomtypeModel record);
}