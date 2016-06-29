package com.duantuke.basic.mappers;

import com.duantuke.basic.po.TeamSku;
import com.duantuke.basic.po.TeamSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeamSkuMapper {
    int countByExample(TeamSkuExample example);

    int deleteByExample(TeamSkuExample example);

    int deleteByPrimaryKey(Long skuId);

    int insert(TeamSku record);

    int insertSelective(TeamSku record);

    List<TeamSku> selectByExample(TeamSkuExample example);

    TeamSku selectByPrimaryKey(Long skuId);

    int updateByExampleSelective(@Param("record") TeamSku record, @Param("example") TeamSkuExample example);

    int updateByExample(@Param("record") TeamSku record, @Param("example") TeamSkuExample example);

    int updateByPrimaryKeySelective(TeamSku record);

    int updateByPrimaryKey(TeamSku record);
}