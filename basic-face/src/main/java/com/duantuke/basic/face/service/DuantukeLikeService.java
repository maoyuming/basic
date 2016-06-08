package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.po.DuantukeLike;

public interface DuantukeLikeService {

    public int countDuantukeLike(DuantukeLike duantukeLike);

    public int deleteDuantukeLike(DuantukeLike duantukeLike);

    public int deleteByPrimaryKey(Long duantukeLikeId);

    public int insert(DuantukeLike duantukeLike);

    public List<DuantukeLike> selectByDuantukeLike(DuantukeLike duantukeLike);


}