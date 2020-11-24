package tech.icoding.springkafkademo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author : Joe
 * @date : 2020/11/18
 */
@Component
public class MessageListner {
    @KafkaListener(topics = "spring-kafka-demo")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message: " + message);
    }

    /**
     * Kafka 消费是单线程的
     * @param message
     */
    @KafkaListener(topics = "spring-kafka-demo-1")
    public void listenGroupFoo1(String message) {
        System.out.println("Received Message from spring-kafka-demo-1: " + message);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Handled Message: " + message);
    }
}
