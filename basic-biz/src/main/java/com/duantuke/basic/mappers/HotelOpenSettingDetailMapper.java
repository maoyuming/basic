package com.duantuke.basic.mappers;

import com.duantuke.basic.po.HotelOpenSettingDetail;
import com.duantuke.basic.po.HotelOpenSettingDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HotelOpenSettingDetailMapper {
    int countByExample(HotelOpenSettingDetailExample example);

    int deleteByExample(HotelOpenSettingDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HotelOpenSettingDetail record);

    int insertSelective(HotelOpenSettingDetail record);

    List<HotelOpenSettingDetail> selectByExample(HotelOpenSettingDetailExample example);

    HotelOpenSettingDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HotelOpenSettingDetail record, @Param("example") HotelOpenSettingDetailExample example);

    int updateByExample(@Param("record") HotelOpenSettingDetail record, @Param("example") HotelOpenSettingDetailExample example);

    int updateByPrimaryKeySelective(HotelOpenSettingDetail record);

    int updateByPrimaryKey(HotelOpenSettingDetail record);
}