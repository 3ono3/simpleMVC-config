package com.jing.oa.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author GuoJingyuan
 * @date 2019/10/16
 */
@Service
public class FileService {
    private final static String TARGET_FILE_PATH = "E:\\temp\\mvcfile\\files\\";
    static {
        File targetDir = new File(TARGET_FILE_PATH);
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }
    }
    public void uploadFile(MultipartFile multipartFile) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        File targetFile = new File(TARGET_FILE_PATH + fileName);
        multipartFile.transferTo(targetFile);
    }
}
