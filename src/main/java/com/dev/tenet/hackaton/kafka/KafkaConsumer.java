package com.dev.tenet.hackaton.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.bills-topic}")
    public void pushFromQueue (@Payload String message,
                               @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
                               @Header(KafkaHeaders.OFFSET) Long offset,
                               Acknowledgment ack) throws IOException {
        log.info("messages count {}, partition: {}, offset: {}, msg: {}",  1, partition, offset, message);

        /*
        *
        *  business logic
        *
        */

        ack.acknowledge();
    }
}
