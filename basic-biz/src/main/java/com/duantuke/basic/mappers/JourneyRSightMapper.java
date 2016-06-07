package com.duantuke.basic.mappers;

import com.duantuke.basic.po.JourneyRSight;
import com.duantuke.basic.po.JourneyRSightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JourneyRSightMapper {
    int countByExample(JourneyRSightExample example);

    int deleteByExample(JourneyRSightExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JourneyRSight record);

    int insertSelective(JourneyRSight record);

    List<JourneyRSight> selectByExample(JourneyRSightExample example);

    JourneyRSight selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JourneyRSight record, @Param("example") JourneyRSightExample example);

    int updateByExample(@Param("record") JourneyRSight record, @Param("example") JourneyRSightExample example);

    int updateByPrimaryKeySelective(JourneyRSight record);

    int updateByPrimaryKey(JourneyRSight record);
}