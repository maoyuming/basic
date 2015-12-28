package com.fangbaba.basic.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fangbaba.basic.face.bean.DistrictModel;
import com.fangbaba.basic.po.DistrictModelExample;

public interface DistrictModelMapper {
    int countByExample(DistrictModelExample example);

    int deleteByExample(DistrictModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DistrictModel record);

    int insertSelective(DistrictModel record);

    List<DistrictModel> selectByExample(DistrictModelExample example);

    DistrictModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DistrictModel record, @Param("example") DistrictModelExample example);

    int updateByExample(@Param("record") DistrictModel record, @Param("example") DistrictModelExample example);

    int updateByPrimaryKeySelective(DistrictModel record);

    int updateByPrimaryKey(DistrictModel record);
}