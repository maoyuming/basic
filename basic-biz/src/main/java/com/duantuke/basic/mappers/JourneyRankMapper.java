package com.duantuke.basic.mappers;

import com.duantuke.basic.po.JourneyRank;
import com.duantuke.basic.po.JourneyRankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JourneyRankMapper {
    int countByExample(JourneyRankExample example);

    int deleteByExample(JourneyRankExample example);

    int deleteByPrimaryKey(Long journeyRankId);

    int insert(JourneyRank record);

    int insertSelective(JourneyRank record);

    List<JourneyRank> selectByExample(JourneyRankExample example);

    JourneyRank selectByPrimaryKey(Long journeyRankId);

    int updateByExampleSelective(@Param("record") JourneyRank record, @Param("example") JourneyRankExample example);

    int updateByExample(@Param("record") JourneyRank record, @Param("example") JourneyRankExample example);

    int updateByPrimaryKeySelective(JourneyRank record);

    int updateByPrimaryKey(JourneyRank record);
}