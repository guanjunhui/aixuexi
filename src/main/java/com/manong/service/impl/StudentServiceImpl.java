package com.manong.service.impl;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manong.mapper.StudentMapper;
import com.manong.service.StudentService;
import com.manong.util.PageResult;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult queryStudents() {
        PageHelper.startPage(1,5);
        PageInfo<T> pageInfo = new PageInfo<T>(studentMapper.queryStudents());
        PageResult pageResult = new PageResult(pageInfo);
        return pageResult;
    }
}
