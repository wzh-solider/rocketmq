package com.solider.rocketmq_use_fast.service;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

/**
 * @author <a href="https://github.com/wzh-solider">solider</a>
 * @version 1.0
 * @description:
 * @Date 2024/7/28 22:12
 * @since 1.0
 */
public interface ProducerService {

    /**
     * 发送单向消息
     */
    void oneWayProducerService(DefaultMQProducer producer, Message message) throws Exception;

    /**
     * 发送延迟消息
     */
    void delayProducerService(DefaultMQProducer producer, Message message) throws Exception;
}
