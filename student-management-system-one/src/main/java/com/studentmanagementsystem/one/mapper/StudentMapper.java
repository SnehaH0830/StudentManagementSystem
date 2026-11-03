package com.studentmanagementsystem.one.mapper;

import com.studentmanagementsystem.one.dto.StudentDto;
import com.studentmanagementsystem.one.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student){
        StudentDto studentDto=new StudentDto(student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail());
        return studentDto;
    }

    public static Student maptoStudent(StudentDto studentDto){
        Student student = new Student(studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail());
        return student;
    }
}
