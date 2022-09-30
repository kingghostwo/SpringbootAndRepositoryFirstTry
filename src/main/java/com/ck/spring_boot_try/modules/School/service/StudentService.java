package com.ck.spring_boot_try.modules.School.service;

import com.ck.spring_boot_try.modules.School.entity.Student;
import com.ck.spring_boot_try.modules.common.vo.Result;
import com.ck.spring_boot_try.modules.common.vo.SearchVo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    Result<Student> editStudent(Student student);

    Student getStudentById(Integer studentId);

    Page<Student> getStudentBySearchVo(SearchVo searchVo);

}
