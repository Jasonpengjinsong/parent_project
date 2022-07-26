package com.halead.oss.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String upLoad(MultipartFile file);
}
