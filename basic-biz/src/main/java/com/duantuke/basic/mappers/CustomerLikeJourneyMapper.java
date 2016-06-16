package com.duantuke.basic.mappers;

import java.util.List;

import com.duantuke.basic.po.CustomerLikeJourneyExample;
import com.duantuke.basic.po.Journey;

public interface CustomerLikeJourneyMapper {
    int countByExample(CustomerLikeJourneyExample example);

    List<Journey> selectByExample(CustomerLikeJourneyExample example);

}