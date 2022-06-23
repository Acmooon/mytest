package com.example.springbootdemo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapper.WorkAreaMapper;
import com.example.pojo.WorkAreaTest;
import com.google.gson.Gson;

@CrossOrigin(origins = {"*","null"}) //用于跨域请求，*代表允许响应所有的跨域请求
// @SuppressWarnings("all") 用于忽略报错
@RestController
public class Controller  {
    private Gson gson = new Gson();

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @Autowired
    WorkAreaMapper workAreaMapper;
    @GetMapping("/work")
    public String work() {
        List<WorkAreaTest> workAreaList = workAreaMapper.selectList(null);
        return gson.toJson(workAreaList);
    }

    @GetMapping("/deletwork")
    public String deletWork(){
        String deletStr = "{\"areaId\":\"010000\",\"areaName\":\"北京\",\"parentId\":\"000000\"}";
        WorkAreaTest deletWork = gson.fromJson(deletStr,WorkAreaTest.class);
        System.out.println(deletWork);
        workAreaMapper.deleteById(deletWork);
        List<WorkAreaTest> workAreaList = workAreaMapper.selectList(null);
        return gson.toJson(workAreaList);
    }

    @PostMapping("/insertwork")
    public String insertWork(@RequestBody WorkAreaTest insertWork){
        workAreaMapper.insert(insertWork);
        List<WorkAreaTest> workAreaList = workAreaMapper.selectList(null);
        return gson.toJson(workAreaList);
    }
    
    
}