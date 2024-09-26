package com.whkxdk.controller;

import com.aliyuncs.exceptions.ClientException;
import com.aliyunoss.AliyuOosUtils;
import com.whkxdk.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * className:       FileController
 * author:          wenhao2002
 * date:            2024/5/6 19:04
 */
@Slf4j
@RestController
@RequestMapping("/files")
public class FileController {

    /*使用的自定义依赖*/
    @Autowired
    AliyuOosUtils aliyuOosUtils;
    //本地存储
   /* @PostMapping("/upload")
    public Result File(String name, Integer age, MultipartFile file) throws IOException {
        log.info("文件上传，{} {} {}", name, age, file);
        //获取原始文件名
        String filename = file.getOriginalFilename();
        int index = 0;
        //使用uuid让文件名唯一
        if (filename != null) {
             index=filename.lastIndexOf(".");
            String exteName=filename.substring(index);
            filename= UUID.randomUUID() +exteName;
        }
        log.info("文件名: {}",filename);
        log.info("{}",file.getInputStream());
        //保存文件到指定文件夹
        file.transferTo(new File("D:\\大学\\大三\\大三下\\资料\\" + filename));

        return Result.success();
    }*/
    @PostMapping("upload")
    public Result File(String name, Integer age, MultipartFile file) throws ClientException, IOException {
       String url= aliyuOosUtils.upload(file);
        log.info("文件上传成功,{},{},{}",name,age,url);
        return Result.success(url);
    }
}
