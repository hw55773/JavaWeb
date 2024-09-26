package com.whkxdk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * className:       DepteLog
 * author:          wenhao2002
 * date:            2024/5/10 22:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepteLog {
    private Integer id;//id
    private Integer operateUser;//操作人id
    private LocalDateTime operateTime;//操作时间
    private String className;//操作类名
    private String methodName;//操作方法名
    private String methodPararms;//操作方法参数
    private String returnValue;//操作方法返回值
    private Long cost;//操作耗时
}
