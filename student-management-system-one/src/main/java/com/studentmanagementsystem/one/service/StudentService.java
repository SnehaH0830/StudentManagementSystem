package com.studentmanagementsystem.one.service;

import com.studentmanagementsystem.one.dto.StudentDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {

    public List<StudentDto> getAllStudents();

    void createStudent(StudentDto student);

    StudentDto getStudentById(Long studentId);

    void updateStudent(@Valid StudentDto studentDto);

    void deleteStudent(Long studentId);
}
