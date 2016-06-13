/**
 * 2016年1月8日下午5:42:09
 * zhaochuanbin
 */
package com.duantuke.basic.face.service;

import com.duantuke.basic.face.bean.SkuInfo;
import com.duantuke.basic.face.bean.SkuQueryIn;


/**
 *  商品服务
 *
 */
public interface SkuService {

    
    /**
     * 查询商品sku
     * @return
     */
    public SkuInfo querySku(SkuQueryIn skuQueryIn);
    
}
