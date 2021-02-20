package com.zyb.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by zhoupanchn on 2020/4/28.
 */
@Component
@Slf4j
public class ConsumerListener {

    /**
     * 自动提交offset
     *
     * @param record
     */
    /*@KafkaListener(topics = "userTopic")
    public void consumeMsg(ConsumerRecord<String, String> record) {
        //获取offset
        log.info("kafka--->消费消息--->offset:{}", record.offset());
        //入库操作
        log.info("kafka--->消费消息--->key:{}", record.key());
        //获取offset
        log.info("kafka--->消费消息--->value:{}", record.value());
    }*/

    /**
     * offset 使用ack模式手动提交offset
     *
     * @param records
     * @param ack
     */
    @KafkaListener(topics = "userTopic")
    public void consumeMsg(List<ConsumerRecord<String, String>> records, Acknowledgment ack) {
        Optional<List<ConsumerRecord<String, String>>> opts = Optional.ofNullable(records);
        if (opts.isPresent()) {
            records.forEach(record -> {
                //获取offset
                log.info("kafka--->消费消息--->offset:{}", record.offset());
                //入库操作
                log.info("kafka--->消费消息--->key:{}", record.key());
                //获取offset
                log.info("kafka--->消费消息--->value:{}", record.value());
            });
            //提交offset
            ack.acknowledge();
        }
    }
}
