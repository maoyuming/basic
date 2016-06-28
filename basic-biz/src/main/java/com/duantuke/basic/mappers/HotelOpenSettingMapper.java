package com.duantuke.basic.mappers;

import com.duantuke.basic.po.HotelOpenSetting;
import com.duantuke.basic.po.HotelOpenSettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HotelOpenSettingMapper {
    int countByExample(HotelOpenSettingExample example);

    int deleteByExample(HotelOpenSettingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HotelOpenSetting record);

    int insertSelective(HotelOpenSetting record);

    List<HotelOpenSetting> selectByExample(HotelOpenSettingExample example);

    HotelOpenSetting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HotelOpenSetting record, @Param("example") HotelOpenSettingExample example);

    int updateByExample(@Param("record") HotelOpenSetting record, @Param("example") HotelOpenSettingExample example);

    int updateByPrimaryKeySelective(HotelOpenSetting record);

    int updateByPrimaryKey(HotelOpenSetting record);
}