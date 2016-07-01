/**
 * 2016年1月8日下午5:42:09
 * zhaochuanbin
 */
package com.duantuke.basic.face.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.duantuke.basic.face.bean.PriceInfo;


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
    public Map<Long,Map<String,BigDecimal>> queryHotelPrices(Long hotelId, Date begintime, Date endtime,List<Long> roomtypeIds);
    
    /**
     * 酒店住宿价格查询
     * @param hotelid
     * @param begintime
     * @param endtime
     * @param roomtypeid
     * @return
     */
    public Map<Long,Map<String,BigDecimal>> queryHotelPrices(Long hotelId, String begintime, String endtime,List<Long> roomtypeIds);
    
    /**
     * 酒店住宿价格查询
     * 返回json结构的价格信息
     * @param hotelid
     * @param begintime
     * @param endtime
     * @param roomtypeid
     * @return
     */
    public Map<Long,List<PriceInfo>> queryHotelPriceInfos(Long hotelId, String begintime, String endtime,List<Long> roomtypeIds);
    

    /**
     * 将map的价格转换为list
     * @param priceMap
     * @return
     */
	public List<PriceInfo> fillPriceInfo(Map<String,BigDecimal> priceMap);
    
    
}
