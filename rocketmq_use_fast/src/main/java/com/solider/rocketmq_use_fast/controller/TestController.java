package com.solider.rocketmq_use_fast.controller;

import com.solider.rocketmq_use_fast.demo.COneWayTest;
import com.solider.rocketmq_use_fast.service.MqTestService;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://github.com/wzh-solider">solider</a>
 * @version 1.0
 * @description:
 * @Date 2024/7/28 21:42
 * @since 1.0
 */
@RestController
public class TestController {

    @Autowired
    private MqTestService mqTestService;

    /**
     * 发送单向消息
     */
    @PostMapping("/oneway")
    public void oneWayProducerService() throws Exception {
        mqTestService.oneWayProducerService(new DefaultMQProducer(), new Message());
    }
}
