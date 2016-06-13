package com.duantuke.basic.mappers;

import com.duantuke.basic.po.RecommendItem;
import com.duantuke.basic.po.RecommendItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecommendItemMapper {
    int countByExample(RecommendItemExample example);

    int deleteByExample(RecommendItemExample example);

    int deleteByPrimaryKey(Long recommendItemId);

    int insert(RecommendItem record);

    int insertSelective(RecommendItem record);

    List<RecommendItem> selectByExample(RecommendItemExample example);

    RecommendItem selectByPrimaryKey(Long recommendItemId);

    int updateByExampleSelective(@Param("record") RecommendItem record, @Param("example") RecommendItemExample example);

    int updateByExample(@Param("record") RecommendItem record, @Param("example") RecommendItemExample example);

    int updateByPrimaryKeySelective(RecommendItem record);

    int updateByPrimaryKey(RecommendItem record);
}