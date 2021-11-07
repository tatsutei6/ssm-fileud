package org.tei.ssmfileud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.tei.ssmfileud.entity.ItemEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {
    @RequestMapping(value = "/upload", method = {RequestMethod.POST, RequestMethod.GET})
    public String upload(@RequestPart MultipartFile file, HttpServletResponse response) throws IOException {
        if (file != null) {
            //1、设置response 响应头
            response.reset(); //设置页面不缓存,清空buffer
            response.setCharacterEncoding("UTF-8"); //字符编码
            response.setContentType("multipart/form-data"); //二进制传输数据
            //设置响应头
            String fileName = file.getOriginalFilename();
            if (fileName == null) {
                fileName = "downloadFile";
            }
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

            response.getOutputStream().write(file.getBytes());
        } else {
            return "上传文件为null，请重新上传文件";
        }

        return "文件上传成功";
    }

}
