package com.solider.rocketmq_use_fast.utils;

import lombok.SneakyThrows;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author <a href="https://github.com/wzh-solider">solider</a>
 * @version 1.0
 * @description:
 * @Date 2024/7/25 22:09
 * @since 1.0
 */
// @Component
public class SimpleMQUtil {

    // private DefaultMQProducer producer;

    /**
     * 创建生产者
     */
    public static DefaultMQProducer createProducer(String groupName, String namesrvAddr) {
        DefaultMQProducer producer = new DefaultMQProducer(groupName);
        producer.setNamesrvAddr(namesrvAddr);
        return producer;
    }

    /**
     * 同步发送消息
     */
    @SneakyThrows
    public DefaultMQProducer send(String topic, String msg, DefaultMQProducer producer) {
        Message message = new Message(topic, msg.getBytes());
        producer.send(message);
        return producer;
    }

    /**
     * 异步发送消息
     */
    @SneakyThrows
    public static DefaultMQProducer sendAsync(DefaultMQProducer producer, String topic, String msg, SendCallback sendCallback) {
        Message message = new Message(topic, msg.getBytes());
        producer.send(message, sendCallback);
        return producer;
    }
}
