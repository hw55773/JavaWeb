package com.whkxdk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * className:       User
 * author:          wenhao2002
 * date:            2024/5/1 19:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private String userPassword;
    private Integer depteId;
    private String avatar;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
