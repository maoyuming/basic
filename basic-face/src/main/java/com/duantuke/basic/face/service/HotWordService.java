package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.po.HotWord;

/**
 *  热词 service
 */
public interface HotWordService {

    
    /**
     * 查询商品sku
     * @return
     */
    public List<HotWord> queryHotWords(HotWord hotWord);
    
}
