package com.solider.rocketmq_use_fast.demo;

import com.solider.rocketmq_use_fast.annotation.AutoExecute;
import com.solider.rocketmq_use_fast.common.enums.MqType;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://github.com/wzh-solider">solider</a>
 * @version 1.0
 * @description:
 * @Date 2024/7/28 20:34
 * @since 1.0
 */
@Component
public class COneWayTest {

    /**
     * 发送单向消息
     */
    @AutoExecute(mqType = MqType.PRODUCER, groupName = "oneway-producer-group",
            topicName = "onewayTopic", content = "日志xxx")
    public void oneWayProducerService(DefaultMQProducer producer, Message message) throws Exception {
        producer.start();
        producer.sendOneway(message);
        System.out.println("发送成功");
    }
}
