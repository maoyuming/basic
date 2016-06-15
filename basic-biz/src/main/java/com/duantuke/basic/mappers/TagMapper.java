package com.duantuke.basic.mappers;

import com.duantuke.basic.po.Tag;
import com.duantuke.basic.po.TagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TagMapper {
    int countByExample(TagExample example);

    int deleteByExample(TagExample example);

    int deleteByPrimaryKey(Long tagId);

    int insert(Tag record);

    int insertSelective(Tag record);

    List<Tag> selectByExample(TagExample example);

    Tag selectByPrimaryKey(Long tagId);

    int updateByExampleSelective(@Param("record") Tag record, @Param("example") TagExample example);

    int updateByExample(@Param("record") Tag record, @Param("example") TagExample example);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
    
    List<Tag> queryTagsByHotelId(@Param("hotelId") Long hotelId);

}