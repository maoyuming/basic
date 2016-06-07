package com.duantuke.basic.mappers;

import com.duantuke.basic.po.MealRank;
import com.duantuke.basic.po.MealRankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MealRankMapper {
    int countByExample(MealRankExample example);

    int deleteByExample(MealRankExample example);

    int deleteByPrimaryKey(Long mealRankId);

    int insert(MealRank record);

    int insertSelective(MealRank record);

    List<MealRank> selectByExample(MealRankExample example);

    MealRank selectByPrimaryKey(Long mealRankId);

    int updateByExampleSelective(@Param("record") MealRank record, @Param("example") MealRankExample example);

    int updateByExample(@Param("record") MealRank record, @Param("example") MealRankExample example);

    int updateByPrimaryKeySelective(MealRank record);

    int updateByPrimaryKey(MealRank record);
}