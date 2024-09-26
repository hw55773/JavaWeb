package com.whkxdk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * className:       Depte
 * author:          wenhao2002
 * date:            2024/5/1 19:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Depte {
    private Integer id;
    private String depteName;
    private String cagrotery;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
