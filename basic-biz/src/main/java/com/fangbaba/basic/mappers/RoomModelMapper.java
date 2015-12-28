package com.fangbaba.basic.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fangbaba.basic.face.bean.RoomModel;
import com.fangbaba.basic.po.RoomModelExample;

public interface RoomModelMapper {
    int countByExample(RoomModelExample example);

    int deleteByExample(RoomModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoomModel record);

    int insertSelective(RoomModel record);

    List<RoomModel> selectByExample(RoomModelExample example);

    RoomModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RoomModel record, @Param("example") RoomModelExample example);

    int updateByExample(@Param("record") RoomModel record, @Param("example") RoomModelExample example);

    int updateByPrimaryKeySelective(RoomModel record);

    int updateByPrimaryKey(RoomModel record);
}