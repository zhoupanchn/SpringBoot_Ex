package com.zyb.kafka.config;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by zhoupanchn on 2020/4/28.
 */
@ConfigurationProperties(prefix = "spring.kafka")
@Configuration("KafkaPropertiesExtra")
@Primary
public class KafkaPropertiesExtra extends KafkaProperties {
    private final ConsumerExtra consumerExtra = new ConsumerExtra();

    public static class ConsumerExtra {
        private Boolean batchListener = false;

        public Boolean getBatchListener() {
            return batchListener;
        }

        public void setBatchListener(Boolean batchListener) {
            this.batchListener = batchListener;
        }
    }

    public ConsumerExtra getConsumerExtra() {
        return this.consumerExtra;
    }
}
