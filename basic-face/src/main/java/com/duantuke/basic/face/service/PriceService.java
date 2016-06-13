/**
 * 2016年1月8日下午5:42:09
 * zhaochuanbin
 */
package com.duantuke.basic.face.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;


/**
 *  价格服务
 *
 */
public interface PriceService {

    
    /**
     * 酒店住宿价格查询
     * @param hotelid
     * @param begintime
     * @param endtime
     * @param roomtypeid
     * @return
     */
    public Map<Long,Map<String,BigDecimal>> queryHotelPrices(Long hotelId, Date begintime, Date endtime,Long roomtypeId);
    
}
