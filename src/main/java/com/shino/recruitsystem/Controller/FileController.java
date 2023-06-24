package com.shino.recruitsystem.Controller;

import com.shino.recruitsystem.Pojo.Account;
import com.shino.recruitsystem.Pojo.Resume;
import com.shino.recruitsystem.Service.AccountService;
import com.shino.recruitsystem.Service.ResumeService;
import com.shino.recruitsystem.Service.SeekerInfoService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/file")
public class FileController {
    @Autowired
    AccountService accountService;
    @Autowired
    SeekerInfoService seekerInfoService;
    @Autowired
    ResumeService resumeService;
    private String filepath="";
    @PostMapping(value = "/upload")
    public Object uploading(@RequestParam("file") MultipartFile file, Principal principal) {
        String username = principal.getName();
        Account user = accountService.getByUsername(username);
        System.out.println(user.getUsername());
        File targetFile = new File(filepath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try (FileOutputStream out = new FileOutputStream(filepath + file.getOriginalFilename());){
            out.write(file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
        Resume resume=new Resume();
        resume.setSeeker_UUID(user.getUUID());
        resume.setContent(file.getOriginalFilename());
        resumeService.saveOrUpdate(resume);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("data",file.getOriginalFilename());
        return map;
    }

    @RequestMapping("/download/{resumeID}")
    public void downLoad(HttpServletResponse response, @PathVariable("resumeID") Long resumeID) throws UnsupportedEncodingException {
        Resume resume=resumeService.getById(resumeID);
        String filename=resume.getContent();
        String filePath = filepath ;
        File file = new File(filePath + "/" + filename);
        if(file.exists()){
            response.setContentType("application/octet-stream");
            response.setHeader("content-type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(filename,"utf8"));
            byte[] buffer = new byte[1024];
            //输出流
            OutputStream os = null;
            try(FileInputStream fis= new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);) {
                os = response.getOutputStream();
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
