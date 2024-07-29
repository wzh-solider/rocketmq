package com.solider.rocketmq_use_fast.service;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;

import java.io.IOException;

/**
 * @author <a href="https://github.com/wzh-solider">solider</a>
 * @version 1.0
 * @description:
 * @Date 2024/7/29 23:23
 * @since 1.0
 */
public interface ConsumerService {
    void msConsumer(DefaultMQPushConsumer defaultMQPushConsumer) throws MQClientException, IOException;
}
