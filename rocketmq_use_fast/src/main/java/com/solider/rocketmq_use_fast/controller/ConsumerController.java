package com.solider.rocketmq_use_fast.controller;

import com.solider.rocketmq_use_fast.service.ConsumerService;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author <a href="https://github.com/wzh-solider">solider</a>
 * @version 1.0
 * @description:
 * @Date 2024/7/29 23:22
 * @since 1.0
 */
@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @PostMapping("/consumer")
    public void consumer() throws IOException, MQClientException {
        consumerService.msConsumer(new DefaultMQPushConsumer());
    }
}
