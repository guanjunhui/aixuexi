package com.manong.controller;

import com.alibaba.fastjson.JSON;
import com.manong.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("student")
public class StudentController{

    @Autowired
    private StudentService studentService;

    @ResponseBody
    @RequestMapping("list")
    private String studentList(){
       return JSON.toJSONString(studentService.queryStudents());
    }


}
