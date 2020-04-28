package com.zpchn.springboot.kafka.controller;

import com.alibaba.fastjson.JSON;
import com.zpchn.springboot.kafka.entry.User;
import com.zpchn.springboot.kafka.utils.KafkaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhoupanchn on 2020/4/28.
 */
@RestController
public class ProducerController {
    @Autowired
    private KafkaUtil kafkaUtil;

    @PostMapping("user/saveUser")
    public void saveUser(@RequestBody User user) {
        for (int i = 0; i <= 5; i++) {
            user.setId(user.getId() + 1);
            kafkaUtil.send("userTopic", JSON.toJSONString(user));
        }
        System.out.println("消息发送成功！");
    }
}
