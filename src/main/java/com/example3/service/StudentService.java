package com.example3.service;

import com.example3.model.Faculty;
import com.example3.model.Student;
import com.example3.model.StudentAge;

import java.util.Collection;

public interface StudentService {
    Student addStudent (Student student);
    Student findStudent (long id);

    Collection<Student> getByAge(Integer min, Integer max);

    Student editStudent (long id, Student student);
    void deleteStudent (long id);

    Faculty findFaculty(String name);

    Integer getStudentCount();
    StudentAge getAverageAge();
    Collection<Student> getTopFiveStudent();

    Collection<Student> getAllStudents();
}