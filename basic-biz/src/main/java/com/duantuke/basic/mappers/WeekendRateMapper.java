package com.duantuke.basic.mappers;

import com.duantuke.basic.po.WeekendRate;
import com.duantuke.basic.po.WeekendRateExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface WeekendRateMapper {
    int countByExample(WeekendRateExample example);

    int deleteByExample(WeekendRateExample example);

    int deleteByPrimaryKey(Long weekendRateId);

    int insert(WeekendRate record);

    int insertSelective(WeekendRate record);

    List<WeekendRate> selectByExample(WeekendRateExample example);

    WeekendRate selectByPrimaryKey(Long weekendRateId);

    int updateByExampleSelective(@Param("record") WeekendRate record, @Param("example") WeekendRateExample example);

    int updateByExample(@Param("record") WeekendRate record, @Param("example") WeekendRateExample example);

    int updateByPrimaryKeySelective(WeekendRate record);

    int updateByPrimaryKey(WeekendRate record);
    
    

    List<WeekendRate> findWeekendRates(@Param("hotelid") Long hotelid, @Param("roomtypeids") List<Long> roomtypeids, @Param("weeks") List<Integer> weeks);
}