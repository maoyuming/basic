package com.duantuke.basic.mappers;

import com.duantuke.basic.po.LPushLog;
import com.duantuke.basic.po.LPushLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LPushLogMapper {
    int countByExample(LPushLogExample example);

    int deleteByExample(LPushLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LPushLog record);

    int insertSelective(LPushLog record);

    List<LPushLog> selectByExample(LPushLogExample example);

    LPushLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LPushLog record, @Param("example") LPushLogExample example);

    int updateByExample(@Param("record") LPushLog record, @Param("example") LPushLogExample example);

    int updateByPrimaryKeySelective(LPushLog record);

    int updateByPrimaryKey(LPushLog record);
}