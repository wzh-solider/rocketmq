package com.solider.rocketmq_use_fast.demo;

import com.solider.rocketmq_use_fast.constant.MqConstant;
import com.solider.rocketmq_use_fast.utils.SimpleMQUtil;
import lombok.SneakyThrows;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @author <a href="https://github.com/wzh-solider">solider</a>
 * @version 1.0
 * @description:
 * @Date 2024/7/25 22:12
 * @since 1.0
 */
// @Component
public class BSimpleTest {
    //
    // @Autowired
    // private SimpleMQUtil simpleMQUtil;

    @Test
    public void asyncProducer() throws Exception {
        DefaultMQProducer producer = SimpleMQUtil.createProducer("async-producer-group", MqConstant.NAME_SRV_ADDR);

        producer.start();

        // 异步发送消息
        SimpleMQUtil.sendAsync(producer, "asyncTopic", "我是一个异步发送的消息", new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("发送成功");
            }

            @Override
            public void onException(Throwable e) {
                System.out.println("发送失败" + e.getMessage());
            }
        });

        System.out.println("我先执行");
        System.in.read();
    }
}
