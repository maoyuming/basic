package com.fangbaba.basic.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fangbaba.basic.face.service.HotelService;
import com.fangbaba.basic.face.service.RoomService;
import com.fangbaba.basic.face.service.RoomtypeService;
import com.mk.kafka.client.stereotype.MkMessageService;
import com.mk.kafka.client.stereotype.MkTopicConsumer;


@MkMessageService
public class StandardKafkaConsumer {
	@Autowired
	private HotelService hotelService;
	@Autowired
	private RoomtypeService roomtypeService;
	@Autowired
	private RoomService roomService;
	

	private Logger logger = LoggerFactory.getLogger(StandardKafkaConsumer.class);

	@MkTopicConsumer(topic = "Switch_PmsSyncHotel",  group = "Basic_Switch_PmsSyncHotel",serializerClass = "com.mk.kafka.client.serializer.StringDecoder")
	public void consumeHotel(String json) {
		logger.info("Switch_PmsSyncHotel consume begin:" + json);
		hotelService.syncHotelInfo(json);
		logger.info("Switch_PmsSyncHotel consume end:" + json);
	}
}
