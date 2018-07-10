package com.manong.mapper;

import com.manong.model.Student;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public interface StudentMapper {

    List<T> queryStudents();

}
