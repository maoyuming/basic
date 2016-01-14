package com.fangbaba.basic.face.service;

import com.fangbaba.basic.face.bean.GdsType;

public interface GdsTypeService {

	/**
	 * 保存
	 * @param record
	 * @return
	 */
    public int save(GdsType record);
    
    /**
     * 根据分销商类型，查询渠道信息
     * @param otatype
     * @return
     */
    public GdsType queryGdsTypeByOtatype(Integer otatype);
}
