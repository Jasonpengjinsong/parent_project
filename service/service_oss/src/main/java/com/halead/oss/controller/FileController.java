package com.halead.oss.controller;


import com.halead.oss.service.FileService;
import com.halead.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @title: FileController
 * @Author ppjjss
 * @Date: 2022/7/25 21:01
 * @Version 1.0
 */

@Api(description="阿里云文件管理")
@RestController
@RequestMapping("/admin/oss/file")
public class FileController {

    @Autowired
    private FileService fileService;

    public R upload(@ApiParam(name = "file", value = "文件", required = true)
                    @RequestParam("file") MultipartFile file){

        String url = fileService.upLoad(file);
        return R.ok().message("文件上传成功").data("url",url);
    }

}
