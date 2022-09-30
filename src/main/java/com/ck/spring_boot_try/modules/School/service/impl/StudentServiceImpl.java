package com.ck.spring_boot_try.modules.School.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.ck.spring_boot_try.modules.School.entity.Student;
import com.ck.spring_boot_try.modules.School.repository.StudentRepository;
import com.ck.spring_boot_try.modules.School.service.StudentService;
import com.ck.spring_boot_try.modules.common.vo.Result;
import com.ck.spring_boot_try.modules.common.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;


public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Result<Student> editStudent(Student student) {
        return new Result<Student>(Result.ResultStatus.SUCCESS.status,"edit success",student);
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.findById(studentId).get();
    }


    @Override
    public Page<Student> getStudentBySearchVo(SearchVo searchVo) {

        searchVo.initSearchVo();

        Student student = new Student();
        student.setStudentName(searchVo.getKeyWord());
        student.setBirthPlace(searchVo.getKeyWord());
        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withMatcher("studentName", Matcher -> Matcher.contains())
                .withMatcher("birthPlace", Matcher -> Matcher.contains())
                .withIgnorePaths("studentId");
        Example<Student> example = Example.of(student, matcher);


        Sort.Direction directions = StringUtils.isBlank(searchVo.getSort()) ||
                searchVo.getSort().equalsIgnoreCase("asc") ?
                    Sort.Direction.ASC : Sort.Direction.DESC;
        String properties = StringUtils.isBlank(searchVo.getOrderBy()) ? "studentId" : searchVo.getOrderBy();
//        new的sort 不知为何会报错，先暂时令其保持完整
//        Sort sort = new Sort (directions, properties);
//        Sort sort = new Sort(Sort.Direction.ASC,"studentId");
        Pageable pageable = PageRequest.of(searchVo.getCurrentPage(), searchVo.getPageSize() );

        studentRepository.findAll(example,pageable);
        return null;
    }
}
