package com.blogs.dashboard.controller;

import com.blogs.dashboard.model.comment;
import com.blogs.dashboard.model.dashboardModel;
import com.blogs.dashboard.model.tempResponse;
import com.blogs.dashboard.service.dashboardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin("*")
public class dashboardController
{
    @Autowired
    dashboardService service;
    @Value("${project.image}")
    private String path="images/";
    @CrossOrigin(allowedHeaders ="*",origins="http://localhost:4200")
    @GetMapping("/showBlogs")
    public ResponseEntity<?> shoB()
    {
        return new ResponseEntity<>(service.showBlogs(), HttpStatus.OK);
    }
    @PostMapping("/addComment")
    public ResponseEntity<?> addC(@RequestBody comment com)
    {
        System.out.println(com);
        return new ResponseEntity<>(service.addComm(com),HttpStatus.OK);
    }
    @GetMapping("getComments/{vId}")
    public ResponseEntity<?> showC(@PathVariable String vId)
    {
        return new ResponseEntity<>(service.showCom(vId),HttpStatus.OK);
    }
    private Logger logger= LoggerFactory.getLogger(dashboardController.class);
    @Autowired
    private ObjectMapper mapp;
    @PostMapping("/putBlogs")
    public ResponseEntity<?> putBlog(@RequestParam("file")MultipartFile file,@RequestParam("blogData")String blogData){
        String fileName=null;
        dashboardModel model=null;
        try{
            fileName=this.service.uploadImage(path,file);
            model=mapp.readValue(blogData,dashboardModel.class);
            System.out.println(model);
            return new ResponseEntity<>(service.addBlog(model), HttpStatus.CREATED);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This is getting into exception");
        }

    }
}
