package com.duantuke.basic.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.duantuke.basic.face.service.HotelOpenSettingDetailService;
import com.duantuke.basic.mappers.HotelOpenSettingDetailMapper;
import com.duantuke.basic.po.HotelOpenSettingDetail;
import com.duantuke.basic.po.HotelOpenSettingDetailExample;
import com.google.common.collect.Lists;

/**
 * Created by nolan on 16/4/11.
 * description:
 */
public class HotelOpenSettingDetailServiceImpl implements HotelOpenSettingDetailService {

    @Autowired
    private HotelOpenSettingDetailMapper hotelOpenSettingDetailMapper;

    @Override
    public List<HotelOpenSettingDetail> queryOpenSetting(Long hotelid, Long roomtypeid, Date begindate, Date enddate) {
        if (hotelid == null || roomtypeid == null || begindate == null || enddate == null) {
            return Lists.newArrayList();
        }

        HotelOpenSettingDetailExample example = new HotelOpenSettingDetailExample();
        HotelOpenSettingDetailExample.Criteria criteria = example.createCriteria();
        criteria.andDayBetween(begindate, enddate);
        criteria.andRoomtypeIdEqualTo(roomtypeid);
        criteria.andHotelIdEqualTo(hotelid);
        return hotelOpenSettingDetailMapper.selectByExample(example);
    }
}
