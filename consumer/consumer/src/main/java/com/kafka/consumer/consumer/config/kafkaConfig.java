package com.kafka.consumer.consumer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class kafkaConfig {

    @KafkaListener(topics = appconstant.LOCATION_UPDATE_TOPIC, groupId = appconstant.GROUP_ID)
    public void updatedLocation(String value) {

        System.out.println(value);

    }

}
