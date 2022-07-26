package com.halead.oss.service.impl;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.halead.base.HaledException;
import com.halead.oss.service.FileService;
import com.halead.oss.utils.ConstantPropertiesUtil;
import org.apache.commons.lang3.RandomUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

/**
 * @title: FileServiceImpl
 * @Author ppjjss
 * @Date: 2022/7/25 20:36
 * @Version 1.0
 */
@Service
public class FileServiceImpl implements FileService {

    /**
     * 文件上传
     * @param file
     * @return
     */
    @Override
    public String upLoad(MultipartFile file) {

        //获取阿里云存储相关常量
        String endPoint = ConstantPropertiesUtil.END_POINT;
        String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtil.BUCKET_NAME;
        String fileHost = ConstantPropertiesUtil.FILE_HOST;
        String uploadUrl = null;
        try {
            OSSClient ossClient = new OSSClient(endPoint, accessKeyId, accessKeySecret);
            if(!ossClient.doesBucketExist(bucketName)){
                ossClient.createBucket(bucketName);
                ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            }
            String original = file.getOriginalFilename();
            String filename = UUID.randomUUID().toString();
            String filetype = original.substring(original.lastIndexOf("."));
            String finalFileName =filename+filetype;
            String filePath = new DateTime().toString("yyyy/MM/dd");
            String fileUrl = fileHost+"/"+filePath+"/"+finalFileName;
            InputStream inputStream = file.getInputStream();
            ossClient.putObject(bucketName, fileUrl, inputStream);
            ossClient.shutdown();
            uploadUrl="http://"+bucketName+"."+endPoint+"/"+fileUrl;
        } catch (IOException e) {
            throw new HaledException();
        }

        return uploadUrl;
    }
}
