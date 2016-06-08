package com.duantuke.basic.mappers;

import com.duantuke.basic.po.DuantukeLike;
import com.duantuke.basic.po.DuantukeLikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DuantukeLikeMapper {
    int countByExample(DuantukeLikeExample example);

    int deleteByExample(DuantukeLikeExample example);

    int deleteByPrimaryKey(Long duantukeLikeId);

    int insert(DuantukeLike record);

    int insertSelective(DuantukeLike record);

    List<DuantukeLike> selectByExample(DuantukeLikeExample example);

    DuantukeLike selectByPrimaryKey(Long duantukeLikeId);

    int updateByExampleSelective(@Param("record") DuantukeLike record, @Param("example") DuantukeLikeExample example);

    int updateByExample(@Param("record") DuantukeLike record, @Param("example") DuantukeLikeExample example);

    int updateByPrimaryKeySelective(DuantukeLike record);

    int updateByPrimaryKey(DuantukeLike record);
}