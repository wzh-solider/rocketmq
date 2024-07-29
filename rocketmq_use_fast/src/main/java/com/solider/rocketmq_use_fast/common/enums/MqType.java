package com.solider.rocketmq_use_fast.common.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author <a href="https://github.com/wzh-solider">solider</a>
 * @version 1.0
 * @description:
 * @Date 2024/7/29 22:55
 * @since 1.0
 */
@AllArgsConstructor
public enum MqType {

    PRODUCER("producer", "生产者"),
    CONSUMER("consumer", "消费者"),
    ;

    private final String type;
    private final String desc;
}
