package com.whkxdk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * className:       pageBean
 * author:          wenhao2002
 * date:            2024/5/3 20:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long total;
    private List<User> userList;

}
