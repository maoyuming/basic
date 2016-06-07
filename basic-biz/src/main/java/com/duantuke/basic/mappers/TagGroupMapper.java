package com.duantuke.basic.mappers;

import com.duantuke.basic.po.TagGroup;
import com.duantuke.basic.po.TagGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TagGroupMapper {
    int countByExample(TagGroupExample example);

    int deleteByExample(TagGroupExample example);

    int deleteByPrimaryKey(Long tagGroupId);

    int insert(TagGroup record);

    int insertSelective(TagGroup record);

    List<TagGroup> selectByExample(TagGroupExample example);

    TagGroup selectByPrimaryKey(Long tagGroupId);

    int updateByExampleSelective(@Param("record") TagGroup record, @Param("example") TagGroupExample example);

    int updateByExample(@Param("record") TagGroup record, @Param("example") TagGroupExample example);

    int updateByPrimaryKeySelective(TagGroup record);

    int updateByPrimaryKey(TagGroup record);
}