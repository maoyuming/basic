package com.duantuke.basic.mappers;

import com.duantuke.basic.esbean.input.SightInputBean;
import com.duantuke.basic.po.Sight;
import com.duantuke.basic.po.SightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SightMapper {
    int countByExample(SightExample example);

    int deleteByExample(SightExample example);

    int deleteByPrimaryKey(Long sightId);

    int insert(Sight record);

    int insertSelective(Sight record);

    List<Sight> selectByExample(SightExample example);

    Sight selectByPrimaryKey(Long sightId);

    int updateByExampleSelective(@Param("record") Sight record, @Param("example") SightExample example);

    int updateByExample(@Param("record") Sight record, @Param("example") SightExample example);

    int updateByPrimaryKeySelective(Sight record);

    int updateByPrimaryKey(Sight record);
    
    List<SightInputBean> queryEsInputSights(@Param("sightId") Long sightId);
}