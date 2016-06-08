package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.po.DuantukeComment;

public interface DuantukeCommentService {
    public int countDuantukeComment(DuantukeComment duantukeComment);

    public int deleteDuantukeComment(DuantukeComment duantukeComment);

    public int deleteByPrimaryKey(Long duantukeCommentId);

    public int insert(DuantukeComment duantukeComment);

    public List<DuantukeComment> selectByDuantukeComment(DuantukeComment duantukeComment);

}