package com.example3.repository;

import com.example3.model.Student;
import com.example3.model.StudentAge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface StudentRepository  extends JpaRepository<Student, Long> {

    Collection<Student> findByAgeBetween(Integer min, Integer max);


    Student findByName(String name);
    @Query(value = "select  count (*) from student", nativeQuery = true)
    Integer getStudentCount();
    @Query(value = "select  avg(s.age) as age from Student s")
    StudentAge getAvarageStudentAge();
    @Query(value = "select * from student order by id desc limit 5",nativeQuery = true)
    Collection<Student> getTopFiveStudent();


}