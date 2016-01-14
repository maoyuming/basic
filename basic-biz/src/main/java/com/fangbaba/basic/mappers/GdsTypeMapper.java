package com.fangbaba.basic.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fangbaba.basic.face.bean.GdsType;
import com.fangbaba.basic.po.GdsTypeExample;

public interface GdsTypeMapper {
    int countByExample(GdsTypeExample example);

    int deleteByExample(GdsTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GdsType record);

    int insertSelective(GdsType record);

    List<GdsType> selectByExample(GdsTypeExample example);

    GdsType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GdsType record, @Param("example") GdsTypeExample example);

    int updateByExample(@Param("record") GdsType record, @Param("example") GdsTypeExample example);

    int updateByPrimaryKeySelective(GdsType record);

    int updateByPrimaryKey(GdsType record);
}