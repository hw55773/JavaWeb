package com.aliyunoss;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * className:       AliyunOosAtuoConfigure
 * author:          wenhao2002
 * date:            2024/5/12 12:34
 */
@Configuration//当前类为Spring配置类
@EnableConfigurationProperties(AliyuOosPropertise.class)//导入AliOSSProperties类，并交给SpringIOC管理
public class AliyunOosAtuoConfigure {
    /*private static final AliyuOosPropertise aliyuOosPropertise=new AliyuOosPropertise();
    * 不能这样使用，因为这样AliyuOosPropertise获取不到springboot配置文件中的配置信息(因为加了
    * @ConfigurationProperties(prefix = "aliyun.oss")注解)
    * */

    @Bean//创建AliOSSUtils对象，并交给SpringIOC容器 ；通过@Bean注解的name/value属性指定bean名称, 如果未指定, 默认是方法名
    public AliyuOosUtils aliyuOosUtils(AliyuOosPropertise aliyuOosPropertise){
        AliyuOosUtils aliyuOosUtils=new AliyuOosUtils(aliyuOosPropertise);

        //aliyuOosUtils.setAliyuOosPropertise(aliyuOosPropertise);
        return aliyuOosUtils;
    }
}
