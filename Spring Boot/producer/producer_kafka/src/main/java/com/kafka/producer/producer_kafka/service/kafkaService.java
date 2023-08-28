package com.kafka.producer.producer_kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.producer.producer_kafka.config.AppConstant;

@Service
public class kafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Logger logger=LoggerFactory.getLogger(kafkaService.class);

    public boolean updateLocation(String location) {
        this.kafkaTemplate.send(AppConstant.LOCATION_TOPIC_NAME, location);

        logger.info("Location updated : "+location);
        return true;
    }

}
