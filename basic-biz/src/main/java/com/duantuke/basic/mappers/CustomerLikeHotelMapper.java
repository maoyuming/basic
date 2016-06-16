package com.duantuke.basic.mappers;

import java.util.List;

import com.duantuke.basic.po.CustomerLikeHotelExample;
import com.duantuke.basic.po.Hotel;

public interface CustomerLikeHotelMapper {
    int countByExample(CustomerLikeHotelExample example);

    List<Hotel> selectByExample(CustomerLikeHotelExample example);

}