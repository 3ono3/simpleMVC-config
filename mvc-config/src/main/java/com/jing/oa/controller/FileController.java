package com.jing.oa.controller;

import com.jing.oa.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @author GuoJingyuan
 * @date 2019/10/16
 */
@Controller
@RequestMapping("/file")
public class FileController {
    private static Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String fileIndex() {
        return "fileManager";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView fileUpload(@RequestParam("file")MultipartFile file) {
        ModelAndView modelAndView = new ModelAndView("fileManager");
        if (file.isEmpty()) {
            modelAndView.addObject("uploadResult", "上传失败，文件为空，请重新选择") ;
        }
        try {
            fileService.uploadFile(file);
        } catch (IOException e) {
            logger.error("文件上传失败：", e);
            modelAndView.addObject("uploadResult", "上传失败，文件为空，请重新选择") ;
        }
        modelAndView.addObject("uploadResult", "文件上传成功") ;
        return modelAndView;
    }
}
