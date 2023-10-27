package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
  private static Map<Integer, Student> studentMap = new HashMap<>();
  private static int seq = 0;

  //  Map이 매번 초기화되는 것 방지(1건 추가)
  public StudentRepositoryImpl() {
    Student student = new Student();
    student.setName("홍길동");
    student.setMajor("컴퓨터공학");
    student.setPoint(3.0f);
    add(student);
  }

  @Override
  public List<Student> findAll() {
    return new ArrayList<>(studentMap.values());
  }

  @Override
  public Student findById(int studentId) {
    Student student = studentMap.get(studentId);
    return student;
  }

  @Override
  public Student removeById(int studentId) {
//    정상적으로 지워지면 remove에 담기고 정상적으로 지워지지 않으면 null 반환
    Student removeStudent = studentMap.remove(studentId);
    return removeStudent;
  }


  //  put도 비정상적일 경우 null을 던지므로 Integer처리
  @Override
  public Integer add(Student student) {
    Integer result = null;
//    참조되기 전에 먼저 증가시킴
    student.setStudentId(++seq);
    Student addedStudent = studentMap.put(seq, student);
    if (addedStudent != null)
      result = student.getStudentId();
    return result;
  }

  @Override
  public Student update(int studentId, Student student) {
    if (findById(studentId) != null)
      studentMap.put(seq, student);
    else add(student);
    return student;
  }
}
