package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDTO;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
  private final StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getAllStudent(){
    return studentRepository.findAll();
  }

  public Student getStudentInfo(int studentId){
    return studentRepository.findById(studentId);
  }

  public String removeStudent(int studentId){
    Student removedStudent = studentRepository.removeById(studentId);
    String result = "";
    if(removedStudent != null)
      result = "정상적으로 삭제되었습니다.";
    else
      result = "삭제 과정에서 오류가 발생했습니다.";
    return result;
  }

  public String addStudent(Student student){
    String result = "";
    Student addedStudent = studentRepository.add(student);
    System.out.println(addedStudent);
    if(addedStudent == null)
      result = "정상적으로 추가되었습니다.";
    else
      result = "등록 과정에서 오류가 발생했습니다.";
    return result;
  }

  public String updateStudent(int studentId, StudentDTO studentDto){
    Student foundStudent = studentRepository.findById(studentId);
    foundStudent.setPoint(studentDto.getPoint());
    studentRepository.update(studentId, foundStudent);
    return "수정 완료";
  }
}