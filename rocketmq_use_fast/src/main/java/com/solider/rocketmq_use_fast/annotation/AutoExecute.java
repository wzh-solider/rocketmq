package com.solider.rocketmq_use_fast.annotation;

import com.solider.rocketmq_use_fast.common.enums.MqType;
import com.sun.istack.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author <a href="https://github.com/wzh-solider">solider</a>
 * @version 1.0
 * @description: 自动处理注解
 * @Date 2024/7/28 20:48
 * @since 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoExecute {
    /**
     * 是否开启自动执行
     */
    boolean enable() default true;

    /**
     * 对象类型
     */
    @NotNull
    MqType mqType();

    /**
     * 执行
     */
    String subExpression() default "*";

    /**
     * 组名
     */
    String groupName() default "rocketmq_default_group";

    /**
     * 消息主题
     */
    String topicName();

    /**
     * 消息内容
     */
    String content() default "";
}
