package com.studentmanagementsystem.one.service.impl;

import com.studentmanagementsystem.one.dto.StudentDto;
import com.studentmanagementsystem.one.entity.Student;
import com.studentmanagementsystem.one.mapper.StudentMapper;
import com.studentmanagementsystem.one.repository.StudentRepository;
import com.studentmanagementsystem.one.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getAllStudents() {
            List<Student> students=studentRepository.findAll();
            List<StudentDto> studentDtos = students.stream().map((student)-> StudentMapper.mapToStudentDto(student)).collect(Collectors.toList());
            return studentDtos;
    }

    @Override
    public void createStudent(StudentDto studentDto) {

        Student student =StudentMapper.maptoStudent(studentDto);
        studentRepository.save(student);

    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student= studentRepository.findById(studentId).get();
        StudentDto studentDto=StudentMapper.mapToStudentDto(student);

        return studentDto;
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        studentRepository.save(StudentMapper.maptoStudent(studentDto));

    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);

    }


}
