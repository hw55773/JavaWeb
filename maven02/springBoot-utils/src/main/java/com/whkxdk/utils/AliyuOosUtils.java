package com.whkxdk.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * className:       AliyuOosUtils
 * author:          wenhao2002
 * date:            2024/5/7 20:19
 */
@Component
public class AliyuOosUtils {
    //获取凭证
    @Autowired
    AliyuOosPropertise aliyuOosPropertise;
    //获取密钥
    EnvironmentVariableCredentialsProvider credentialsProvider;

    {
        try {
            credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        } catch (ClientException e) {
            throw new RuntimeException(e);
        }
    }

    public String upload (MultipartFile file) throws ClientException, IOException {
        //获取域名
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        //@Value("${aliyun.oss.endpoint}")
        String endpoint = aliyuOosPropertise.getEndpoint();
        // 填写Bucket名称，例如examplebucket。
        //@Value("${aliyun.oss.bucketName}")
        String bucketName = aliyuOosPropertise.getBucketName();
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);
        //获取文件输入流
        InputStream inputStream = file.getInputStream();
        //避免文件重复
        String filename=file.getOriginalFilename();
        if (filename != null) {
            filename= UUID.randomUUID()+filename.substring(filename.lastIndexOf("."));
        }
        // 创建PutObjectRequest对象,上传到阿里云服务器
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, filename, inputStream);
        // 创建PutObject请求。
        PutObjectResult result = ossClient.putObject(putObjectRequest);
       //url
        String url= endpoint.split("//")[0]+"//"+ bucketName +"."+ endpoint.split("//")[1]+"/"+filename;

        ossClient.shutdown();
        return url;
    }
}
