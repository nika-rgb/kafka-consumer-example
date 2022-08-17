package com.consumer.first.firstConsumer.listener;

import com.consumer.first.firstConsumer.model.OrderKafkaMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaFirstConsumer {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private final static String TOPIC = "orders";
    private final static String GROUP_ID = "kafka-demo-consumer-group";

    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    public void receiveOrderMessage(@Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key, @Payload OrderKafkaMessage order, @Header(KafkaHeaders.OFFSET) String offset, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) String partitionId) {
        logger.info("Message Consumed");
        logger.info("key: {}, offset: {}, partitionId: {}\n" +
                "value: {}", key, offset, partitionId, order.toString());
    }

}
