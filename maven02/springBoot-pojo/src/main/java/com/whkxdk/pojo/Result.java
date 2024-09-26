package com.whkxdk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * className:       Result
 * author:          wenhao2002
 * date:            2024/4/5 22:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private Integer code;// 0表示失败，1表示成功
    private String msg;//返回信息
    private  Object data;//返回数据
   public static Result success(){
        return new Result(1,"success",null);
   }
    public static Result success(Object data){
        return new Result(1,"success",data);
    }
    public static Result error(String msg){
        return new Result(0,msg,null);
    }

}
