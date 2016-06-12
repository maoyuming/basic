package com.duantuke.basic.mappers;

import com.duantuke.basic.po.Meal;
import com.duantuke.basic.po.MealExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MealMapper {
    int countByExample(MealExample example);

    int deleteByExample(MealExample example);

    int deleteByPrimaryKey(Long mealId);

    int insert(Meal record);

    int insertSelective(Meal record);

    List<Meal> selectByExample(MealExample example);

    Meal selectByPrimaryKey(Long mealId);

    int updateByExampleSelective(@Param("record") Meal record, @Param("example") MealExample example);

    int updateByExample(@Param("record") Meal record, @Param("example") MealExample example);

    int updateByPrimaryKeySelective(Meal record);

    int updateByPrimaryKey(Meal record);
}