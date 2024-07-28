package com.solider.rocketmq_use_fast.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author <a href="https://github.com/wzh-solider">solider</a>
 * @version 1.0
 * @description:
 * @Date 2024/7/28 22:21
 * @since 1.0
 */
@Data
@ConfigurationProperties(prefix = "mq.test")
public class MqProperties {

    /**
     * mq端口号
     */
    private String port;

    /**
     * mq的namesrv地址
     */
    private String namesrvAddr;
}
