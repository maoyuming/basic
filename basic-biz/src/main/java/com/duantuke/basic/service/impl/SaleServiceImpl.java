package com.duantuke.basic.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.enums.IsvisibleEnum;
import com.duantuke.basic.exception.OpenException;
import com.duantuke.basic.face.service.SaleService;
import com.duantuke.basic.mappers.SaleMapper;
import com.duantuke.basic.mappers.SalesRHotelMapper;
import com.duantuke.basic.po.Sale;
import com.duantuke.basic.po.SaleExample;
import com.duantuke.basic.po.SalesRHotel;
import com.duantuke.basic.po.SalesRHotelExample;

/**
 * c用户信息相关接口
 * @author tankai
 */
@Service
public class SaleServiceImpl implements SaleService {
	
	private static Logger logger = LoggerFactory.getLogger(SaleServiceImpl.class);
	
	@Autowired
	private SaleMapper saleMapper;
	@Autowired
	private SalesRHotelMapper salesRHotelMapper;

	/**
	 * 根据手机号码查询销售消息
	 */
	@Override
	public Sale querySaleByPhone(String phone) {
		
		SaleExample example = new SaleExample();
		SaleExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andPhoneEqualTo(phone);
		hoCriteria.andIsvisibleEqualTo(IsvisibleEnum.yes.getCode());
		List<Sale> models =  saleMapper.selectByExample( example);
		if(CollectionUtils.isNotEmpty(models)){
			return models.get(0);
		}
		return null;
	}
	
	/**
	 * 根据销售id查询销售信息
	 * @param saleId
	 * @return
	 */
	public Sale querySaleById(Long saleId) {
		
		SaleExample example = new SaleExample();
		SaleExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andSalesIdEqualTo(saleId);
		hoCriteria.andIsvisibleEqualTo(IsvisibleEnum.yes.getCode());
		List<Sale> models =  saleMapper.selectByExample( example);
		if(CollectionUtils.isNotEmpty(models)){
			return models.get(0);
		}
		return null;
	}

	@Override
	public Sale querySaleByHotelId(Long hotelId) {
		//根据酒店id查询销售id
		List<SalesRHotel> list=	querySalesRHotel(hotelId, null);
		if(CollectionUtils.isNotEmpty(list)){
			for (SalesRHotel salesRHotel : list) {
				Sale sale = querySaleById(salesRHotel.getSaleId());
				return sale;
			}
		}
		return null;
	}
	
	
	/**
	 * 根据酒店id或者销售id查询关系
	 * @param hotelId
	 * @param saleId
	 * @return
	 */
	public List<SalesRHotel> querySalesRHotel(Long hotelId,Long saleId){

		
		if(hotelId==null&&saleId==null){
			throw new OpenException("酒店id和销售id全是空");
		}
		
		SalesRHotelExample example = new SalesRHotelExample();
		SalesRHotelExample.Criteria hoCriteria = example.createCriteria();
		if(hotelId!=null){
			hoCriteria.andHotelIdEqualTo(hotelId);
		}
		if(saleId!=null){
			hoCriteria.andSaleIdEqualTo(saleId);
		}
		List<SalesRHotel> models =  salesRHotelMapper.selectByExample( example);
		return models;
	}


}
