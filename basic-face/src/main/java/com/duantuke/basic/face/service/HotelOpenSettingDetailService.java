package com.duantuke.basic.face.service;

import java.util.Date;
import java.util.List;

import com.duantuke.basic.po.HotelOpenSettingDetail;

/**
 * 酒店房型开关明细状态服务接口
 * <p>
 * Created by nolan on 16/4/11.
 * description:
 */
public interface HotelOpenSettingDetailService {

    /**
     * 查询指定时间段某个酒店指定房型的关闭状态
     *
     * @param hotelid    酒店id
     * @param roomtypeid 房型id
     * @param begindate  开始时间
     * @param enddate    结束时间
     * @return
     */
    List<HotelOpenSettingDetail> queryOpenSetting(Long hotelid, Long roomtypeid, Date begindate, Date enddate);
}
