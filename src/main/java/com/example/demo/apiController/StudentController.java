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

  @GetMapping("")
  public List<Student> getAllStudent(){
    List<Student> allStudent = studentService.getAllStudent();
    System.out.println("controller에서 출력");
    allStudent.forEach(student -> System.out.println(student.getStudentId() + ":" + student.getName()));
    return allStudent;
  }

  @GetMapping("/{studentId}")
  public Student getStudentInfo(@PathVariable int studentId) {
    return studentService.getStudentInfo(studentId).get();
  }

  @DeleteMapping("/{studentId}")
  public String removeStudent(@PathVariable int studentId){
    String res = studentService.removeStudent(studentId);
    return res;
  }

  @PostMapping
  public String addStudent(@RequestBody Student student){
    String res = studentService.addStudent(student);
    return res;
  }

  @PutMapping("/{studentId}")
  public String updateStudent(@PathVariable int studentId,
                              @RequestBody StudentDTO studentDTO){
    String res = studentService.updateStudent(studentId, studentDTO);
    return res;
  }

  @GetMapping("/major/{major}")
  public List<Student> getAllStudentsByMajor(@PathVariable String major){
    return studentService.getAllStudentsByMajor(major);
  }

  @GetMapping("/point/{point}")
  public List<Student> getAllStudentsByPoint(@PathVariable int point){
    return studentService.getAllStudentsByPoint(point);
  }

  @GetMapping("/major/{major}/point/{point}")
  public List<Student> getAllStudentsByMajorAndPoint(@PathVariable String major,
                                                     @PathVariable int point) {
    return studentService.getAllStudentByMajorAndPoint(major, point);
  }

}