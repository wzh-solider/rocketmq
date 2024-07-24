package com.solider.rocketmq_use_fast.demo;

import com.solider.rocketmq_use_fast.constant.MqConstant;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.junit.Test;

import java.util.List;

/**
 * @author <a href="https://github.com/wzh-solider">solider</a>
 * @version 1.0
 * @description:
 * @Date 2024/7/24 22:43
 * @since 1.0
 */
public class ASimpleTest {

    /**
     * 生产者测试
     */
    @Test
    public void simpleProcess() throws Exception {
        // 创建一个默认的生产者
        DefaultMQProducer producer = new DefaultMQProducer("test-producer-group");

        // 连接namesrv
        producer.setNamesrvAddr(MqConstant.NAME_SRV_ADDR);

        // 启动
        producer.start();

        // 创建消息
        Message message = new Message("testTopic", "我是一个简单的消息".getBytes());

        // 发送消息
        SendResult sendResult = producer.send(message);
        System.out.println(sendResult);

        // 关闭生产者
        producer.shutdown();
    }

    /**
     * 消费者测试
     */
    @Test
    public void simpleConsumer() throws Exception {
        // 创建消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test-consumer-group");

        // 连接namesrv
        consumer.setNamesrvAddr(MqConstant.NAME_SRV_ADDR);

        // 订阅主题
        consumer.subscribe("testTopic", "*");

        // 设置监听器
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                // 消费处理，业务处理
                System.out.println("////////////");
                System.out.println("我是消费者");
                System.out.println(msgs.get(0).toString());
                System.out.println("消费上下文" + context);

                String msg = new String(msgs.get(0).getBody());
                System.out.println("消息内容：" + msg);


                // 返回值 CONSUME_SUCCESS 消费成功，出消息队列
                // RECONSUME_LATER 消费失败，重新消费
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        // 启动
        consumer.start();

        // 挂起jvm
        System.in.read();
    }
}
