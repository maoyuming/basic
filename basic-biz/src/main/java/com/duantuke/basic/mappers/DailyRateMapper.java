package com.duantuke.basic.mappers;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.duantuke.basic.po.DailyRate;
import com.duantuke.basic.po.DailyRateExample;

public interface DailyRateMapper {
    int countByExample(DailyRateExample example);

    int deleteByExample(DailyRateExample example);

    int deleteByPrimaryKey(Long dailyRateId);

    int insert(DailyRate record);

    int insertSelective(DailyRate record);

    List<DailyRate> selectByExample(DailyRateExample example);

    DailyRate selectByPrimaryKey(Long dailyRateId);

    int updateByExampleSelective(@Param("record") DailyRate record, @Param("example") DailyRateExample example);

    int updateByExample(@Param("record") DailyRate record, @Param("example") DailyRateExample example);

    int updateByPrimaryKeySelective(DailyRate record);

    int updateByPrimaryKey(DailyRate record);
    
    List<DailyRate> findDailyRates(@Param("hotelid") Long hotelid, @Param("roomtypeids") List<Long> roomtypeids, @Param("begintime") Date begintime, @Param("endtime") Date endtime);
}