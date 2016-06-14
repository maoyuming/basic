package com.duantuke.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duantuke.basic.face.service.RoomTypeService;
import com.duantuke.basic.po.RoomType;

@Controller
@RequestMapping(value = "/room")
public class RoomtypeController extends BaseController {
	
	@Autowired
	private RoomTypeService roomTypeService;
	
	
	@RequestMapping(value = "/query")
	public ResponseEntity<List<RoomType>> query(Long hotelId) {
		List<RoomType> list = roomTypeService.queryRoomtypeByHotleId(hotelId);
		return new ResponseEntity<List<RoomType>>(list, HttpStatus.OK);
	}
}
