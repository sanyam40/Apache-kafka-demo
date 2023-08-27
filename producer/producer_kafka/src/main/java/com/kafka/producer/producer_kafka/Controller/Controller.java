package com.kafka.producer.producer_kafka.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kafka.producer.producer_kafka.service.kafkaService;

@RestController
public class Controller {

    @Autowired
    private kafkaService kafkaService;

    @PostMapping("/updateLocation")
    public ResponseEntity<?> updateLocation() {

        for (int i = 1; i <= 20; i++) {
            this.kafkaService.updateLocation(
                    "( " + Math.round(Math.random() * 100) + " , " + Math.round(Math.random() * 100) + " " + ")");
        }

        return new ResponseEntity<>(Map.of("message", "Location updated"), HttpStatus.OK);
    }

}
