package com.duantuke.basic.mappers;

import com.duantuke.basic.po.RoomType;
import com.duantuke.basic.po.RoomTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoomTypeMapper {
    int countByExample(RoomTypeExample example);

    int deleteByExample(RoomTypeExample example);

    int insert(RoomType record);

    int insertSelective(RoomType record);

    List<RoomType> selectByExample(RoomTypeExample example);

    int updateByExampleSelective(@Param("record") RoomType record, @Param("example") RoomTypeExample example);

    int updateByExample(@Param("record") RoomType record, @Param("example") RoomTypeExample example);
}