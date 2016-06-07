package com.duantuke.basic.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mk.kafka.client.stereotype.MkMessageService;
import com.mk.kafka.client.stereotype.MkTopicProducer;

@MkMessageService
public class StandardKafkaProducer {

	private Logger logger = LoggerFactory.getLogger(StandardKafkaProducer.class);

	@MkTopicProducer(topic = "standard_test_topic", partitions = 1, serializerClass = "com.mk.kafka.client.serializer.StringEncoder", replicationFactor = 1)
	public void sendMessage(String value) {
		logger.debug("StandardKafkaProducer send a message:" + value);
	}
}
