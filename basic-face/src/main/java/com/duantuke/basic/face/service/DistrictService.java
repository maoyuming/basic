package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.face.base.RetInfo;
import com.duantuke.basic.po.District;

public interface DistrictService {
	List<District> queryAllDistricts();

	/**
	 * 根据 district Code 查询 DistrictModel
	 * @param districtcode
	 * @return
	 */
	RetInfo<District> queryByCode( String districtcode);
}
