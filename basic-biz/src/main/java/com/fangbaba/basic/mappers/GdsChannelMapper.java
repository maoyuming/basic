package com.fangbaba.basic.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fangbaba.basic.face.bean.GdsChannel;
import com.fangbaba.basic.po.GdsChannelExample;

public interface GdsChannelMapper {
    int countByExample(GdsChannelExample example);

    int deleteByExample(GdsChannelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GdsChannel record);

    int insertSelective(GdsChannel record);

    List<GdsChannel> selectByExample(GdsChannelExample example);

    GdsChannel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GdsChannel record, @Param("example") GdsChannelExample example);

    int updateByExample(@Param("record") GdsChannel record, @Param("example") GdsChannelExample example);

    int updateByPrimaryKeySelective(GdsChannel record);

    int updateByPrimaryKey(GdsChannel record);
}