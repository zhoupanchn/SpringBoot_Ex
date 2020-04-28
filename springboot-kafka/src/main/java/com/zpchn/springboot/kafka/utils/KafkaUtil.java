package com.zpchn.springboot.kafka.utils;

import com.alibaba.fastjson.JSON;
import kafka.admin.AdminUtils;
import kafka.utils.ZkUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.security.JaasUtils;
import org.apache.zookeeper.ZKUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.StringUtils;

import java.util.Properties;

/**
 * Created by zhoupanchn on 2020/4/28.
 */
@Configuration
@Slf4j
public class KafkaUtil {
    @Autowired
    private KafkaTemplate kafkaTemplate;
    @Value("${kafka.zookeeper.servers}")
    private String        zkServers;
    @Value("${kafka.topic.userTopic}")
    private String        userTopic;


    @Bean("initKafka")
    public String init() {
        log.info("Kafka-->初始化");
        //创建topic
        createKafkaTopic(userTopic, 1, 1);
        //删除topic
        //deleteKafkaTopic();
        return null;
    }

    /**
     * 创建kafka的topic, 已存在则不创建
     *
     * @param topicName 需要创建的主题名称
     */
    private void createKafkaTopic(String topicName, int partition, int replication) {
        if (StringUtils.isEmpty(zkServers)) {
            log.error("Kafka-->未配置zk, 无法创建Topic-->{}", topicName);
            return;
        }

        ZkUtils zkUtils = null;
        try {
            zkUtils = ZkUtils.apply(zkServers, 30000, 30000, JaasUtils.isZkSecurityEnabled());
            if (AdminUtils.topicExists(zkUtils, topicName)) {
                log.info("Kafka-->Topic已存在-->{}", topicName);
            } else {
                AdminUtils.createTopic(zkUtils, topicName, partition, replication, new Properties(), AdminUtils.createTopic$default$6());
                log.info("Kafka-->Topic创建成功-->{}", topicName);
            }
        } catch (Exception e) {
            log.error("Kafka-->Topic创建异常-->{}", topicName, e);
        } finally {
            if (zkUtils != null) {
                zkUtils.close();
            }
        }
    }

    /**
     * 删除kafka 的topic
     *
     * @param topicName 需要删除的主题名称
     */
    public void deleteKafkaTopic(String topicName) {
        ZkUtils zkUtils = ZkUtils.apply(zkServers, 30000, 30000, JaasUtils.isZkSecurityEnabled());
        AdminUtils.deleteTopic(zkUtils, topicName);
        log.info("Kafka-->Topic删除成功-->{}", topicName);
        zkUtils.close();
    }

    /**
     * 生产消息
     * (我们默认topic是存在的, 因为生产环境无法连接zk, 所以无法判断topic是否存在)
     * (对接不同系统时, 注意切换topic)
     *
     * @param key    消息类型
     * @param object 消息体
     */
    @Async
    public void send(String key, Object object) {
        log.info("Kafka-->发送成功-->key: {}", key);
        log.info("Kafka-->发送成功-->value: {}", JSON.toJSONString(object));
        kafkaTemplate.send(userTopic, key, object);
    }
}
