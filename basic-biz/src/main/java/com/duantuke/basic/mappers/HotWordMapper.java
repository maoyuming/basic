package com.duantuke.basic.mappers;

import com.duantuke.basic.po.HotWord;
import com.duantuke.basic.po.HotWordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HotWordMapper {
    int countByExample(HotWordExample example);

    int deleteByExample(HotWordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HotWord record);

    int insertSelective(HotWord record);

    List<HotWord> selectByExample(HotWordExample example);

    HotWord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HotWord record, @Param("example") HotWordExample example);

    int updateByExample(@Param("record") HotWord record, @Param("example") HotWordExample example);

    int updateByPrimaryKeySelective(HotWord record);

    int updateByPrimaryKey(HotWord record);
}