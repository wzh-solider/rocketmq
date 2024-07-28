package com.solider.rocketmq_use_fast.service;

import com.solider.rocketmq_use_fast.annotation.AutoExecute;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

/**
 * @author <a href="https://github.com/wzh-solider">solider</a>
 * @version 1.0
 * @description:
 * @Date 2024/7/28 22:12
 * @since 1.0
 */
public interface MqTestService {

    void oneWayProducerService(DefaultMQProducer producer, Message message) throws Exception;
}
