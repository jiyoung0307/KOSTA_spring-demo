package com.example.demo.apiController;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDTO;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public List<Student> viewAllStudents() {
    return studentService.getAllStudent();
  }

  @GetMapping("/{studentId}")
  public Student getStudentInfo(@PathVariable int studentId) {
    return studentService.getStudentInfo(studentId);
  }

  @DeleteMapping("/{studentId}")
  public String removeStudent(@PathVariable int studentId) {
    String res = studentService.removeStudent(studentId);
    return res;
  }

  @PostMapping
  public String addStudent(@RequestBody Student student) {
    String res = studentService.addStudent(student);
    return res;
  }

  @PutMapping("/{studentId}")
  public String updateStudent(@PathVariable int studentId,
                              @RequestBody StudentDTO studentDTO){
    String res = studentService.updateStudent(studentId, studentDTO);
    return res;
  }
}
