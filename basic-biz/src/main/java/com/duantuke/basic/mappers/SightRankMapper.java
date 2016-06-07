package com.duantuke.basic.mappers;

import com.duantuke.basic.po.SightRank;
import com.duantuke.basic.po.SightRankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SightRankMapper {
    int countByExample(SightRankExample example);

    int deleteByExample(SightRankExample example);

    int deleteByPrimaryKey(Long sightRankId);

    int insert(SightRank record);

    int insertSelective(SightRank record);

    List<SightRank> selectByExample(SightRankExample example);

    SightRank selectByPrimaryKey(Long sightRankId);

    int updateByExampleSelective(@Param("record") SightRank record, @Param("example") SightRankExample example);

    int updateByExample(@Param("record") SightRank record, @Param("example") SightRankExample example);

    int updateByPrimaryKeySelective(SightRank record);

    int updateByPrimaryKey(SightRank record);
}