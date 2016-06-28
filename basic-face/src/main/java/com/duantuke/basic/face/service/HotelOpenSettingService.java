package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.po.HotelOpenSetting;

/**
 * Created by nolan on 16/4/11.
 * description:
 */
public interface HotelOpenSettingService {

    int save(HotelOpenSetting HotelOpenSetting);

    int batchAdd(HotelOpenSetting[] HotelOpenSetting);

    int update(HotelOpenSetting HotelOpenSetting);

    int delete(Long id, String operator);

    int delete(Long id);

    List<HotelOpenSetting> pageQuery(HotelOpenSetting HotelOpenSetting, int pageIndex, int pageSize);

    int count(HotelOpenSetting HotelOpenSetting);

    List<HotelOpenSetting> queryList(Long hotelid);

    List<HotelOpenSetting> queryList(Long hotelid, Long roomtypeid);

    HotelOpenSetting findById(Long id);
}
