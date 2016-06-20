package com.duantuke.basic.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.face.service.HotWordService;
import com.duantuke.basic.mappers.HotWordMapper;
import com.duantuke.basic.po.HotWord;
import com.duantuke.basic.po.HotWordExample;

/**
 * 热词相关接口
 * @author he
 */
@Service
public class HotWordServiceImpl implements HotWordService {
	
	private static Logger logger = LoggerFactory.getLogger(HotWordServiceImpl.class);
	
	@Autowired
	private HotWordMapper hotWordMapper;

	@Override
	public List<HotWord> queryHotWords(HotWord hotWord) {
		HotWordExample example = new HotWordExample();
		HotWordExample.Criteria criteria = example.createCriteria();
		if(hotWord.getProvcode()!=null){
			criteria.andProvcodeEqualTo(hotWord.getProvcode());
		}
		if(hotWord.getCitycode()!=null){
			criteria.andCitycodeEqualTo(hotWord.getCitycode());
		}
		if(hotWord.getDiscode()!=null){
			criteria.andDiscodeEqualTo(hotWord.getDiscode());
		}
		if(hotWord.getBusinessType()!=null){
			criteria.andBusinessTypeEqualTo(hotWord.getBusinessType());
		}
		example.setOrderByClause("priority desc");
		return hotWordMapper.selectByExample(example);
	}
	

}
