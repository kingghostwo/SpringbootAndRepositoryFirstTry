package com.ck.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
@RequestMapping("/file")
public class FileController {

    @PostMapping("/upload")
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
//        指定要下载的文件所在路径
        String path = request.getSession().getServletContext().getRealPath("upload");
//        获得文件名
        String fileName = file.getOriginalFilename();
        System.out.println(path);
        System.out.println(fileName);
        File dir = new File(path, fileName);
        if(!dir.exists()) {
            dir.mkdirs();
        }
        file.transferTo(dir);
        return "success";
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request,HttpServletResponse response,String filename) throws IOException {

        String path = request.getSession().getServletContext().getRealPath("upload");
        //创建该文件对象
        File file = new File(path+File.separator+filename);
        //对文件名编码，防止中文乱码
        filename = this.getFilename (request, filename);
//        设置响应头
        HttpHeaders Headers = new HttpHeaders();
//        通知浏览器
        Headers.setContentDispositionFormData("attachment", filename);
//        定义以流的形式下载返回文件数据
        Headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//        使用spring MVC框架的ResponseEntity对象封装返回下载数据
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                Headers, HttpStatus.OK);

//        //1、设置response 响应头
//        response.reset(); //设置页面不缓存,清空buffer
//        response.setCharacterEncoding("UTF-8"); //字符编码
//        response.setContentType("multipart/form-data"); //二进制传输数据
//        //设置响应头
//        response.setHeader("Content-Disposition",
//                "attachment;fileName="+URLEncoder.encode(filename, "UTF-8"));
//        InputStream input=new FileInputStream(file);
//        //3、 写出文件--输出流
//        OutputStream out = response.getOutputStream();
//
//        byte[] buff =new byte[1024];
//        int index=0;
//        //4、执行 写出操作
//        while((index= input.read(buff))!= -1){
//            out.write(buff, 0, index);
//            out.flush();
//        }
//        out.close();
//        input.close();
//        return null;
    }

    public String getFilename(HttpServletRequest request, String filename) throws UnsupportedEncodingException {
        //IE不同版本User-Agent总出现的关键词
        String[] IEBrowserKeyWords = {"MSIE", "Trident", "Edge"};
        //获取请求头
        String userAgent = request.getHeader("User-Agent");
        for (String keyWord : IEBrowserKeyWords) {
            if (userAgent.contains(keyWord)) {
                //IE内核浏览器同一为UTF-8
                return URLEncoder.encode(filename, "UTF-8");
            }
        }
        //火狐等其他浏览器统一为ISO-8869-1
        return new String(filename.getBytes("UTF-8"), "ISO-8869-1");
    }
}
