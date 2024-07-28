package com.solider.rocketmq_use_fast.aspect;

import com.solider.rocketmq_use_fast.annotation.AutoExecute;
import com.solider.rocketmq_use_fast.common.config.MqProperties;
import com.solider.rocketmq_use_fast.constant.MqConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author <a href="https://github.com/wzh-solider">solider</a>
 * @version 1.0
 * @description: 自动执行切面类
 * @Date 2024/7/28 20:50
 * @since 1.0
 */
@Aspect
@Slf4j
@Component
@EnableConfigurationProperties(MqProperties.class)
public class AutoExecuteAspect {

    @Autowired
    private MqProperties mqProperties;

    @Pointcut("execution(* com.solider.rocketmq_use_fast.service.*.*(..)) && @annotation(com.solider.rocketmq_use_fast.annotation.AutoExecute)")
    public void autoExecute() {
    }

    @Before("autoExecute()")
    public void before(JoinPoint joinPoint) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        AutoExecute annotation = signature.getMethod().getAnnotation(AutoExecute.class);

        // 开启自动执行
        if (annotation.enable()) {
            log.info("填充字段");
            Object[] args = joinPoint.getArgs();
            Class<?> param01 = args[0].getClass();
            param01.getMethod("setProducerGroup", String.class).invoke(args[0], annotation.groupName());
            param01.getMethod("setNamesrvAddr", String.class).invoke(args[0], mqProperties.getNamesrvAddr() + ":" + mqProperties.getPort());

            Class<?> param02 = args[1].getClass();
            // Constructor<?> constructor02 = param02.getDeclaredConstructor(String.class, byte[].class);
            // Object o1 = constructor02.newInstance(annotation.topicName(), annotation.content().getBytes());
            param02.getMethod("setTopic", String.class).invoke(args[1], annotation.topicName());
            param02.getMethod("setBody", byte[].class).invoke(args[1], annotation.content().getBytes());

            // log.info("字段填充成功：message>>>{}", o1);
        } else {
            return;
        }
    }

    @After("autoExecute()")
    public void after(JoinPoint joinPoint) {
        log.info("自动执行结束, 释放资源");

        DefaultMQProducer producer = (DefaultMQProducer) joinPoint.getArgs()[0];
        producer.shutdown();

        log.info("资源释放成功, 关闭=>=>=>=>producer：{}", producer);
    }
}
