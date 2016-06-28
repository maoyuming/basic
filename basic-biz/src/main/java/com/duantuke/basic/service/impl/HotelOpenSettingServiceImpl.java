package com.duantuke.basic.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.duantuke.basic.face.service.HotelOpenSettingService;
import com.duantuke.basic.face.service.RoomTypeService;
import com.duantuke.basic.mappers.HotelOpenSettingDetailMapper;
import com.duantuke.basic.mappers.HotelOpenSettingMapper;
import com.duantuke.basic.po.HotelOpenSetting;
import com.duantuke.basic.po.HotelOpenSettingDetail;
import com.duantuke.basic.po.HotelOpenSettingDetailExample;
import com.duantuke.basic.po.HotelOpenSettingExample;
import com.duantuke.basic.po.RoomType;
import com.duantuke.basic.util.DateUtil;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

/**
 * Created by nolan on 16/4/11.
 * description:
 */
public class HotelOpenSettingServiceImpl implements HotelOpenSettingService {
    private Logger logger = LoggerFactory.getLogger(HotelOpenSettingServiceImpl.class);
    @Autowired
    private HotelOpenSettingMapper hotelOpenSettingMapper;

    @Autowired
    private HotelOpenSettingDetailMapper hotelOpenSettingDetailMapper;

//    @Autowired
//    private BusinessLogUtil businessLogUtil;
//
//    @Autowired
//    private BusinessUtil businessUtil;

    @Autowired
    private RoomTypeService roomtypeService;

    @Override
    public int save(HotelOpenSetting hotelOpenSetting) {
        logger.info("save(HotelOpenSetting hotelOpenSetting): {}>>>>>>start", hotelOpenSetting);
        if (hotelOpenSetting == null || hotelOpenSetting.getHotelId() == null || hotelOpenSetting.getRoomtypeId() == null)
            return 0;

        String roomtypename = "";
        RoomType roomtypeModel = roomtypeService.queryRoomtypeByRoomtypeId(hotelOpenSetting.getRoomtypeId());
        if (roomtypeModel != null) {
            roomtypename = roomtypeModel.getName();
        }
        String busilog = "酒店房型关闭: 房型(%s), 时间段(%s 至 %s)";
//        busilog = String.format(busilog, roomtypename, DateUtil.dateToStr(hotelOpenSetting.getBeginDate(), "yyyy-MM-dd"), DateUtil.dateToStr(hotelOpenSetting.getEndDate(), "yyyy-MM-dd"));
//        businessLogUtil.saveLog(String.valueOf(hotelOpenSetting.getHotelId()), hotelOpenSetting.getCreateuser(), busilog, BussinssTypeEnum.hotelOpenSetting);

        logger.info("保存关房配置");
        int rs = hotelOpenSettingMapper.insert(hotelOpenSetting);

        if (rs > 0) {
            logger.info("根据关房配置同步生成明细");
            reSyncOpenSetting(hotelOpenSetting.getHotelId(), hotelOpenSetting.getRoomtypeId(), hotelOpenSetting.getCreateBy());
        }
        logger.info("save(HotelOpenSetting hotelOpenSetting): {}>>>>>>end", hotelOpenSetting);
        return rs;
    }

    @Override
    public int batchAdd(HotelOpenSetting[] hotelOpenSetting) {
        logger.info("batchAdd(HotelOpenSetting[] hotelOpenSetting): {}>>>begin", hotelOpenSetting);
        int rtncount = 0;
        if (hotelOpenSetting != null && hotelOpenSetting.length > 0) {
            for (HotelOpenSetting openSetting : hotelOpenSetting) {
                if (save(openSetting) > 0)
                    rtncount++;
            }
        }
        logger.info("batchAdd(HotelOpenSetting[] hotelOpenSetting): {}>>>end", hotelOpenSetting);
        return rtncount;
    }

    @Override
    public int update(HotelOpenSetting hotelOpenSetting) {
        logger.info("update(HotelOpenSetting hotelOpenSetting): {}>>>begin", hotelOpenSetting);
        HotelOpenSetting oldhotelOpensetting = findById(hotelOpenSetting.getId());

        logger.info("更新关房配置");
        int result = hotelOpenSettingMapper.updateByPrimaryKey(hotelOpenSetting);

        String roomtypename = "";
        RoomType roomtypeModel = roomtypeService.queryRoomtypeByRoomtypeId(hotelOpenSetting.getRoomtypeId());
        if (roomtypeModel != null) {
            roomtypename = roomtypeModel.getName();
        }
        String oldroomtypename = "";
        roomtypeModel = roomtypeService.queryRoomtypeByRoomtypeId(oldhotelOpensetting.getRoomtypeId());
        if (roomtypeModel != null) {
            oldroomtypename = roomtypeModel.getName();
        }

        String busilog = "酒店房型关闭: 房型(%s), 时间段(%s 至 %s)\n 修改前: 房型(%s), 时间段(%s 至 %s)";
//        busilog = String.format(busilog, roomtypename, DateUtil.dateToStr(hotelOpenSetting.getBeginDate(), "yyyy-MM-dd"), DateUtil.dateToStr(hotelOpenSetting.getEndDate(), "yyyy-MM-dd"), oldroomtypename, DateUtil.dateToStr(oldhotelOpensetting.getBeginDate(), "yyyy-MM-dd"), DateUtil.dateToStr(oldhotelOpensetting.getEndDate(), "yyyy-MM-dd"));
//        businessLogUtil.saveLog(String.valueOf(hotelOpenSetting.getHotelId()), hotelOpenSetting.getCreateuser(), busilog, BussinssTypeEnum.hotelOpenSetting);

        //2. 同步更新关房明细表
        if (result > 0) {
            if (!hotelOpenSetting.getRoomtypeId().equals(oldhotelOpensetting.getRoomtypeId())) {
                //2.1  修改房型， 需同步修改当前房型及前房型的关房明细
                logger.info("修改房型, 需同时更新前房型与当前房型对应关房明细");
                reSyncOpenSetting(oldhotelOpensetting.getHotelId(), oldhotelOpensetting.getRoomtypeId(), hotelOpenSetting.getCreateBy());
            } else {
                //2.2  未修改房型, 只需同步当前房型的关房明细即可
                logger.info("未修改房型, 只需更新当前房型对应关房明细");
            }
            reSyncOpenSetting(hotelOpenSetting.getHotelId(), hotelOpenSetting.getRoomtypeId(), hotelOpenSetting.getCreateBy());
        }
        logger.info("update(HotelOpenSetting hotelOpenSetting): {}>>>end", hotelOpenSetting);
        return result;
    }

    @Override
    public int delete(Long id, String operator) {
        logger.info("1.删除房型开关设置......[start]");
        HotelOpenSetting hotelOpensetting = findById(id);
        if (hotelOpensetting == null || hotelOpensetting.getHotelId() == null || hotelOpensetting.getRoomtypeId() == null)
            return 0;

        String roomtypename = "";
        
        RoomType roomtypeModel = roomtypeService.queryRoomtypeByRoomtypeId(hotelOpensetting.getRoomtypeId());
        
        if (roomtypeModel != null) {
            roomtypename = roomtypeModel.getName();
        }
        String busilog = "酒店房型打开: 房型(%s), 时间段(%s 至 %s)";
//        busilog = String.format(busilog, roomtypename, DateUtil.dateToStr(hotelOpensetting.getBeginDate(), "yyyy-MM-dd"), DateUtil.dateToStr(hotelOpensetting.getEndDate(), "yyyy-MM-dd"));
//        businessLogUtil.saveLog(String.valueOf(hotelOpensetting.getHotelId()), operator, busilog, BussinssTypeEnum.hotelOpenSetting);

        logger.info("2.删除房型开关设置");
        int result = hotelOpenSettingMapper.deleteByPrimaryKey(id);


        logger.info("3.同步更新酒店({})房型({})的关房明细记录", hotelOpensetting.getHotelId(), hotelOpensetting.getRoomtypeId());
        reSyncOpenSetting(hotelOpensetting.getHotelId(), hotelOpensetting.getRoomtypeId(), operator);

        logger.info("4.删除房型开关设置......[end]");
        return result;
    }

    @Override
    public List<HotelOpenSetting> pageQuery(HotelOpenSetting hotelOpenSetting, int pageIndex, int pageSize) {
        HotelOpenSettingExample example = new HotelOpenSettingExample();
        HotelOpenSettingExample.Criteria criteria = example.createCriteria();
        if (hotelOpenSetting.getHotelId() != null) {
            criteria.andHotelIdEqualTo(hotelOpenSetting.getHotelId());
        }
        if (hotelOpenSetting.getRoomtypeId() != null) {
            criteria.andRoomtypeIdEqualTo(hotelOpenSetting.getRoomtypeId());
        }
        example.setLimitStart((pageIndex - 1) * pageSize);
        example.setLimitEnd(pageSize);
        return hotelOpenSettingMapper.selectByExample(example);
    }

    @Override
    public int count(HotelOpenSetting hotelOpenSetting) {
        HotelOpenSettingExample example = new HotelOpenSettingExample();
        HotelOpenSettingExample.Criteria criteria = example.createCriteria();
        if (hotelOpenSetting.getHotelId() != null) {
            criteria.andHotelIdEqualTo(hotelOpenSetting.getHotelId());
        }
        if (hotelOpenSetting.getRoomtypeId() != null) {
            criteria.andRoomtypeIdEqualTo(hotelOpenSetting.getRoomtypeId());
        }
        return hotelOpenSettingMapper.countByExample(example);
    }

    @Override
    public HotelOpenSetting findById(Long id) {
        return hotelOpenSettingMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<HotelOpenSetting> queryList(Long hotelid, Long roomtypeid) {
        if (hotelid == null || roomtypeid == null)
            return null;

        HotelOpenSettingExample example = new HotelOpenSettingExample();
        HotelOpenSettingExample.Criteria criteria = example.createCriteria();
        criteria.andHotelIdEqualTo(hotelid);
        criteria.andRoomtypeIdEqualTo(roomtypeid);
        return hotelOpenSettingMapper.selectByExample(example);
    }

    @Override
    public List<HotelOpenSetting> queryList(Long hotelid) {
        if (hotelid == null)
            return null;

        HotelOpenSettingExample example = new HotelOpenSettingExample();
        HotelOpenSettingExample.Criteria criteria = example.createCriteria();
        criteria.andHotelIdEqualTo(hotelid);
        return hotelOpenSettingMapper.selectByExample(example);
    }

   /* private void deleteRangeDate(Long hotelid, Long roomtypeid, Date begindate, Date enddate) {
        HotelOpenSettingDetailExample example = new HotelOpenSettingDetailExample();
        HotelOpenSettingDetailExample.Criteria criteria = example.createCriteria();
        criteria.andHotelIdEqualTo(hotelid);
        criteria.andRoomtypeIdEqualTo(roomtypeid);
        criteria.andDayBetween(begindate, enddate);
        hotelOpenSettingDetailMapper.deleteByExample(example);
    }*/

   /* private void syncOpenSetting(HotelOpenSetting oldhotelOpenSetting, HotelOpenSetting newhotelOpenSetting) {
        //1. 清除日期区间关闭记录
        if (oldhotelOpenSetting != null)
            deleteRangeDate(oldhotelOpenSetting.getHotelId(), oldhotelOpenSetting.getRoomtypeid(), oldhotelOpenSetting.getBeginDate(), oldhotelOpenSetting.getEndDate());

        //2. 重新生成日期区间关闭记录
        int daynum = DateUtil.diffDay(newhotelOpenSetting.getBeginDate(), newhotelOpenSetting.getEndDate());
        for (int i = 0; i <= daynum; i++) {
            Date ftmpdate = DateUtil.addDateOneDay(newhotelOpenSetting.getBeginDate(), i);
            HotelOpenSettingDetail fHotelOpenSettingDetail = new HotelOpenSettingDetail();
            fHotelOpenSettingDetail.setHotelId(newhotelOpenSetting.getHotelId());
            fHotelOpenSettingDetail.setRoomtypeId(newhotelOpenSetting.getRoomtypeid());
            fHotelOpenSettingDetail.setDay(ftmpdate);
            fHotelOpenSettingDetail.setCreateTime(new Date());
            fHotelOpenSettingDetail.setCreateBy(newhotelOpenSetting.getCreateuser());
            hotelOpenSettingDetailMapper.insert(fHotelOpenSettingDetail);
        }

        //3. 通知去哪儿状态变化
        businessUtil.sendHotelChange(newhotelOpenSetting.getHotelId());
    }*/

    private void reSyncOpenSetting(Long hotelid, Long roomtypeid, String operator) {
        if (hotelid == null || roomtypeid == null) {
            return;
        }

        //1. 清空酒店关房记录明细表
        HotelOpenSettingDetailExample example = new HotelOpenSettingDetailExample();
        HotelOpenSettingDetailExample.Criteria criteria = example.createCriteria();
        criteria.andHotelIdEqualTo(hotelid);
        criteria.andRoomtypeIdEqualTo(roomtypeid);
        hotelOpenSettingDetailMapper.deleteByExample(example);

        //2. 查询酒店对应房型下的所有关房日期段配置信息
        List<HotelOpenSetting> itemList = queryList(hotelid, roomtypeid);

        //3. 计算关房日期时间段并集
        if (itemList != null && itemList.size() > 0) {
            List<Date> dateList = Lists.newArrayList();
            for (HotelOpenSetting openSetting : itemList) {
                int daynum = DateUtil.diffDay(openSetting.getBeginDate(), openSetting.getEndDate());
                for (int i = 0; i <= daynum; i++) {
                    dateList.add(DateUtil.addDateOneDay(openSetting.getBeginDate(), i));
                }
            }
            List<Date> rmduplicatelist = ImmutableSet.copyOf(dateList).asList();

            //4. 重新生成数据
            for (Date day : rmduplicatelist) {
                HotelOpenSettingDetail fHotelOpenSettingDetail = new HotelOpenSettingDetail();
                fHotelOpenSettingDetail.setHotelId(hotelid);
                fHotelOpenSettingDetail.setRoomtypeId(roomtypeid);
                fHotelOpenSettingDetail.setDay(day);
                fHotelOpenSettingDetail.setCreateTime(new Date());
                fHotelOpenSettingDetail.setCreateBy(operator);
                fHotelOpenSettingDetail.setUpdateBy(operator);
                fHotelOpenSettingDetail.setUpdateTime(new Date());
                hotelOpenSettingDetailMapper.insert(fHotelOpenSettingDetail);
            }
        }

        //5. 通知去哪儿状态变化
//        businessUtil.sendHotelChange(hotelid);
    }

    @Override
    public int delete(Long id) {
        return this.delete(id, "system");
    }
}
