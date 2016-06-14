/**
 * 2016年1月8日下午5:42:09
 * zhaochuanbin
 */
package com.duantuke.basic.face.service;

import com.duantuke.basic.face.bean.SkuRequest;
import com.duantuke.basic.face.bean.SkuResponse;


/**
 *  商品服务
 *
 */
public interface SkuService {

    
    /**
     * 查询商品sku
     * @return
     */
    public SkuResponse querySku(SkuRequest skuQueryIn);
    
}
