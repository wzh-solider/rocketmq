package com.solider.rocketmq_use_fast.service.impl;

import com.solider.rocketmq_use_fast.annotation.AutoExecute;
import com.solider.rocketmq_use_fast.service.MqTestService;
import org.apache.rocketmq.client.exception.MQClientException;
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
public class MqTestServiceImpl implements MqTestService {

    /**
     * 发送单向消息
     */
    @AutoExecute(groupName = "oneway-producer-group",
            topicName = "onewayTopic", content = "日志xxx")
    public void oneWayProducerService(DefaultMQProducer producer, Message message) throws Exception {
        producer.start();
        producer.sendOneway(message);
        System.out.println("发送成功");
    }
}
