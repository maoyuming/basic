package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.face.base.RetInfo;
import com.duantuke.basic.po.Province;

public interface ProvinceService {
	List<Province> queryAllProvinces();

	/**
	 * 根据province Code 查询 province
	 * @param provCode
	 * @return
	 */
	RetInfo<Province> queryByCode( String provCode);
}
