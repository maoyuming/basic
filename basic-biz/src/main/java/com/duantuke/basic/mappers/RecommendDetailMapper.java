package com.duantuke.basic.mappers;

import com.duantuke.basic.po.RecommendDetail;
import com.duantuke.basic.po.RecommendDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecommendDetailMapper {
    int countByExample(RecommendDetailExample example);

    int deleteByExample(RecommendDetailExample example);

    int deleteByPrimaryKey(Long recommendDetailId);

    int insert(RecommendDetail record);

    int insertSelective(RecommendDetail record);

    List<RecommendDetail> selectByExampleWithBLOBs(RecommendDetailExample example);

    List<RecommendDetail> selectByExample(RecommendDetailExample example);

    RecommendDetail selectByPrimaryKey(Long recommendDetailId);

    int updateByExampleSelective(@Param("record") RecommendDetail record, @Param("example") RecommendDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") RecommendDetail record, @Param("example") RecommendDetailExample example);

    int updateByExample(@Param("record") RecommendDetail record, @Param("example") RecommendDetailExample example);

    int updateByPrimaryKeySelective(RecommendDetail record);

    int updateByPrimaryKeyWithBLOBs(RecommendDetail record);

    int updateByPrimaryKey(RecommendDetail record);
}