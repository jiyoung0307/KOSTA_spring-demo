package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    // 추가적으로 필요한 메서드 선언하기
    List<Student> findByMajorLike(String major);
    List<Student> findByPointGreaterThanEqual(int point);

    List<Student> findByMajorLikeAndPointGreaterThanEqual(String major, int point);
}