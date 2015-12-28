package com.fangbaba.basic.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.fangbaba.basic.po.ProvinceModel;
import com.fangbaba.basic.po.ProvinceModelExample;

public interface ProvinceModelMapper {
    int countByExample(ProvinceModelExample example);

    int deleteByExample(ProvinceModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProvinceModel record);

    int insertSelective(ProvinceModel record);

    List<ProvinceModel> selectByExample(ProvinceModelExample example);

    ProvinceModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProvinceModel record, @Param("example") ProvinceModelExample example);

    int updateByExample(@Param("record") ProvinceModel record, @Param("example") ProvinceModelExample example);

    int updateByPrimaryKeySelective(ProvinceModel record);

    int updateByPrimaryKey(ProvinceModel record);
}