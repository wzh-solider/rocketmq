package com.solider.rocketmq_use_fast.service.impl;

import com.solider.rocketmq_use_fast.annotation.AutoExecute;
import com.solider.rocketmq_use_fast.common.enums.MqType;
import com.solider.rocketmq_use_fast.service.ProducerService;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Service;

/**
 * @author <a href="https://github.com/wzh-solider">solider</a>
 * @version 1.0
 * @description: mq测试业务类
 * @Date 2024/7/28 22:13
 * @since 1.0
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    /**
     * 发送单向消息
     */
    @Override
    @AutoExecute(mqType = MqType.PRODUCER, groupName = "oneway-producer-group",
            topicName = "onewayTopic", content = "日志xxx")
    public void oneWayProducerService(DefaultMQProducer producer, Message message) throws Exception {
        producer.start();
        producer.sendOneway(message);
        System.out.println("发送成功");
    }

    /**
     * 发送延迟消息
     */
    @Override
    @AutoExecute(mqType = MqType.PRODUCER, groupName = "delay-producer-group",
    topicName = "delayTopic", content = "订单号，座位号")
    public void delayProducerService(DefaultMQProducer producer, Message message) throws Exception {
        producer.start();
        // 设置延时消息
        // 级别：1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
        message.setDelayTimeLevel(3);
        // 发送消息
        producer.send(message);
    }
}
