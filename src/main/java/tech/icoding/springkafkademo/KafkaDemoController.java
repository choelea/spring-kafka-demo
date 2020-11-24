package tech.icoding.springkafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Joe
 * @date : 2020/11/18
 */
@RestController
public class KafkaDemoController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private String topic = "spring-kafka-demo";

    @GetMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestParam String msg) {
        kafkaTemplate.send(topic, msg);
        return ResponseEntity.ok("success");
    }

    @GetMapping("/send1")
    public ResponseEntity<?> sendMessage1(@RequestParam String msg) {
        kafkaTemplate.send("spring-kafka-demo-1", msg);
        return ResponseEntity.ok("success");
    }
}
