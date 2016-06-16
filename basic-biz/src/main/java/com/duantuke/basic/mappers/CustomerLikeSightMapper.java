package com.duantuke.basic.mappers;

import java.util.List;

import com.duantuke.basic.po.CustomerLikeSightExample;
import com.duantuke.basic.po.Sight;

public interface CustomerLikeSightMapper {
    int countByExample(CustomerLikeSightExample example);

    List<Sight> selectByExample(CustomerLikeSightExample example);

}