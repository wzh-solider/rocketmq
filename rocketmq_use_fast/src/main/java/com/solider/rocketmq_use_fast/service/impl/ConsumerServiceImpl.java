package com.solider.rocketmq_use_fast.service.impl;

import com.solider.rocketmq_use_fast.annotation.AutoExecute;
import com.solider.rocketmq_use_fast.common.enums.MqType;
import com.solider.rocketmq_use_fast.service.ConsumerService;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author <a href="https://github.com/wzh-solider">solider</a>
 * @version 1.0
 * @description:
 * @Date 2024/7/29 23:23
 * @since 1.0
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Override
    @AutoExecute(mqType = MqType.CONSUMER, groupName = "ms-consumer-group",
            topicName = "delayTopic")
    public void msConsumer(DefaultMQPushConsumer consumer) throws MQClientException, IOException {
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                System.out.println("收到消息了");
                System.out.println(new String(list.get(0).getBody()));
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        System.in.read();
    }
}
