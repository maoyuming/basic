package com.duantuke.basic.mappers;

import com.duantuke.basic.po.DuantukeComment;
import com.duantuke.basic.po.DuantukeCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DuantukeCommentMapper {
    int countByExample(DuantukeCommentExample example);

    int deleteByExample(DuantukeCommentExample example);

    int deleteByPrimaryKey(Long duantukeCommentId);

    int insert(DuantukeComment record);

    int insertSelective(DuantukeComment record);

    List<DuantukeComment> selectByExample(DuantukeCommentExample example);

    DuantukeComment selectByPrimaryKey(Long duantukeCommentId);

    int updateByExampleSelective(@Param("record") DuantukeComment record, @Param("example") DuantukeCommentExample example);

    int updateByExample(@Param("record") DuantukeComment record, @Param("example") DuantukeCommentExample example);

    int updateByPrimaryKeySelective(DuantukeComment record);

    int updateByPrimaryKey(DuantukeComment record);
}