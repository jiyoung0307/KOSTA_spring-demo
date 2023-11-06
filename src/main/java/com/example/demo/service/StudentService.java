package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDTO;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional(readOnly = true)
    public List<Student> getAllStudent(){
        List<Student> all = studentRepository.findAll();
        System.out.println("service에서 출력");
        all.forEach(student -> System.out.println(student.getStudentId() + ":" + student.getName()));
        return all;
    }

    @Transactional(readOnly = true)
    public Optional<Student> getStudentInfo(int studentId){
        return studentRepository.findById(studentId);
    }

    @Transactional
    public String removeStudent(int studentId){
        studentRepository.deleteById(studentId);
        return "정상적으로 삭제되었습니다.";
    }

    @Transactional
    public String addStudent(Student student){
        String result = "";
        Student addedStudent = studentRepository.save(student);
        System.out.println(addedStudent);
        return "정상적으로 추가되었습니다.";
    }

    @Transactional
    public String updateStudent(int studentId, StudentDTO studentDTO){
        Student foundStudent = studentRepository.findById(studentId).get();
        foundStudent.setPoint(studentDTO.getPoint());
        studentRepository.save(foundStudent);
        return "수정 완료";
    }

    @Transactional(readOnly = true)
    public List<Student> getAllStudentByMajorAndPoint(String major, int point){
        List<Student> all = studentRepository.findByMajorLikeAndPointGreaterThanEqual(major, point);
        return all;
    }

    @Transactional(readOnly = true)
    public List<Student> getAllStudentsByMajor(String major) {
        return studentRepository.findByMajorLike(major);
    }

    @Transactional(readOnly = true)
    public List<Student> getAllStudentsByPoint(int point) {
        return studentRepository.findByPointGreaterThanEqual(point);
    }
}
