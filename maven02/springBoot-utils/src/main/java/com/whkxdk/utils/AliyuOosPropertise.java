package com.whkxdk.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * className:       AliyuOosPropertise
 * author:          wenhao2002
 * date:            2024/5/8 20:13
 */
@Component
@Data
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliyuOosPropertise {
    private String endpoint;
    private String bucketName;

}
