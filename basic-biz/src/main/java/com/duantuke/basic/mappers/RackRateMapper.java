package com.duantuke.basic.mappers;

import com.duantuke.basic.po.RackRate;
import com.duantuke.basic.po.RackRateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RackRateMapper {
    int countByExample(RackRateExample example);

    int deleteByExample(RackRateExample example);

    int deleteByPrimaryKey(Long rackRateId);

    int insert(RackRate record);

    int insertSelective(RackRate record);

    List<RackRate> selectByExample(RackRateExample example);

    RackRate selectByPrimaryKey(Long rackRateId);

    int updateByExampleSelective(@Param("record") RackRate record, @Param("example") RackRateExample example);

    int updateByExample(@Param("record") RackRate record, @Param("example") RackRateExample example);

    int updateByPrimaryKeySelective(RackRate record);

    int updateByPrimaryKey(RackRate record);
}