package com.fangbaba.basic.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import com.fangbaba.basic.face.bean.RoomtypeModel;
import com.fangbaba.basic.mappers.RoomtypeModelMapper;
import com.fangbaba.basic.po.RoomtypeModelExample;
import com.fangbaba.basic.service.impl.RoomtypeServiceImpl;



public class RoomTypeServiceMockTest{

	private RoomtypeServiceImpl impl  =new RoomtypeServiceImpl();
    
    @Test
	public  void testQueryByHotelId() {
    	Long hotelid = 1111L;
    	

    	RoomtypeModelMapper roomtypeModelMapper  = PowerMockito.mock( RoomtypeModelMapperClass.class);
    	impl.setRoomtypeModelMapper(roomtypeModelMapper);
    	
    	

//		RoomtypeModelExample example = new RoomtypeModelExample();
//		RoomtypeModelExample.Criteria criteria = example.createCriteria();
//		criteria.andHotelidEqualTo(hotelid);
    	PowerMockito.when(roomtypeModelMapper.selectByExample((RoomtypeModelExample)Mockito.any()))
    	.thenThrow(new RuntimeException("异常"));
    	
    	try {
			impl.queryByHotelId(hotelid);
		} catch (RuntimeException e) {
			Assert.fail(e.getMessage());
		}
    }
    
    class RoomtypeModelMapperClass implements RoomtypeModelMapper{

		@Override
		public int countByExample(RoomtypeModelExample example) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int deleteByExample(RoomtypeModelExample example) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int deleteByPrimaryKey(Long id) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int insert(RoomtypeModel record) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int insertSelective(RoomtypeModel record) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public List<RoomtypeModel> selectByExample(RoomtypeModelExample example) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public RoomtypeModel selectByPrimaryKey(Long id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int updateByExampleSelective(RoomtypeModel record,
				RoomtypeModelExample example) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int updateByExample(RoomtypeModel record,
				RoomtypeModelExample example) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int updateByPrimaryKeySelective(RoomtypeModel record) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int updateByPrimaryKey(RoomtypeModel record) {
			// TODO Auto-generated method stub
			return 0;
		}
    	
    }
}
