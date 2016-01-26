package com.fangbaba.basic.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fangbaba.basic.face.bean.HotelExtension;
import com.fangbaba.basic.po.HotelExtensionExample;

public interface HotelExtensionMapper {
	int countByExample(HotelExtensionExample example);

	int deleteByExample(HotelExtensionExample example);

	int deleteByPrimaryKey(Long id);

	int insert(HotelExtension record);

	int insertSelective(HotelExtension record);

	List<HotelExtension> selectByExampleWithBLOBs(HotelExtensionExample example);

	List<HotelExtension> selectByExample(HotelExtensionExample example);

	HotelExtension selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") HotelExtension record, @Param("example") HotelExtensionExample example);

	int updateByExampleWithBLOBs(@Param("record") HotelExtension record, @Param("example") HotelExtensionExample example);

	int updateByExample(@Param("record") HotelExtension record, @Param("example") HotelExtensionExample example);

	int updateByPrimaryKeySelective(HotelExtension record);

	int updateByPrimaryKeyWithBLOBs(HotelExtension record);

	int updateByPrimaryKey(HotelExtension record);
}