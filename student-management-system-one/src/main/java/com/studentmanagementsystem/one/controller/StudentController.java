package com.studentmanagementsystem.one.controller;

import com.studentmanagementsystem.one.dto.StudentDto;
import com.studentmanagementsystem.one.service.StudentService;
import com.studentmanagementsystem.one.service.impl.StudentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/students")
    public String listStudents(Model model){

        List<StudentDto> students = studentService.getAllStudents();
        model.addAttribute("students",students);
        return  "students";
    }

    @GetMapping("/students/new")
    public String newStudent(Model model){
        StudentDto student = new StudentDto();
        model.addAttribute("student",student);
        return "createStudent";

    }
    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDto student,
                              BindingResult result,
                              Model model){
        if(result.hasErrors()){
            model.addAttribute("student",student);
            return"createStudent";
        }
        studentService.createStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/students/{studentId}/edit")
    public String editStudent(@PathVariable("studentId") Long studentId,
                              Model model){
        StudentDto student =studentService.getStudentById(studentId);
        model.addAttribute("student",student);
        return "editStudent";

    }
    @PostMapping("/students/{studentId}")
    public String updateStudent(@PathVariable("studentId") Long studentId,
                                @Valid @ModelAttribute("student") StudentDto studentDto,
                                BindingResult result,
                                Model model){
        if(result.hasErrors()){
            model.addAttribute("student", studentDto);
            return "editStudent";
        }
        studentDto.setId(studentId);
        studentService.updateStudent(studentDto);
        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}/delete")
    public String deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}/view")
    public String viewStudent(@PathVariable("studentId") Long studentId,Model model){
        StudentDto student=studentService.getStudentById(studentId);
        model.addAttribute("student",student);
        return "viewStudent";
    }




}
