package com.wh.pojo;

import lombok.*;

import java.time.LocalDateTime;

/**
 * className:       Depte
 * author:          wenhao2002
 * date:            2024/4/27 15:09
 */

//@Setter
//@Getter
//@EqualsAndHashCode

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
