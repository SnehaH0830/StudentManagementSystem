package com.studentmanagementsystem.one.repository;

import com.studentmanagementsystem.one.dto.StudentDto;
import com.studentmanagementsystem.one.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {


}
