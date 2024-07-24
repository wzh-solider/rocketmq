package com.solider.rocketmq_use_fast;

import com.solider.rocketmq_use_fast.constant.MqConstant;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RocketmqUseFastApplicationTests {

    /**
     * 发送消息
     */
    @Test
    void contextLoads(){
    }

}
