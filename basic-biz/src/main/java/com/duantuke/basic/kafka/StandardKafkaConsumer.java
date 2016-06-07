package com.duantuke.basic.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mk.kafka.client.stereotype.MkMessageService;
import com.mk.kafka.client.stereotype.MkTopicConsumer;


@MkMessageService
public class StandardKafkaConsumer {

	private Logger logger = LoggerFactory.getLogger(StandardKafkaConsumer.class);

	@MkTopicConsumer(topic = "standard_test_topic",  group = "standard_test_topic",serializerClass = "com.mk.kafka.client.serializer.StringDecoder")
	public void consume(String json) {
		logger.info("StandardKafkaConsumer consume :" + json);
	}
}
