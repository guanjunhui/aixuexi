package com.manong.service;

import com.manong.model.Student;
import com.manong.util.PageResult;
import org.apache.poi.ss.formula.functions.T;

public interface StudentService {
    PageResult queryStudents();
}
