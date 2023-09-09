package com.example3.service;


import com.example3.model.Faculty;
import com.example3.model.Student;
import com.example3.model.StudentAge;
import com.example3.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentServiceImpl implements StudentService{


    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent (Student student){
        return studentRepository.save(student);
    }

    public Student findStudent(long id){
        return studentRepository.findById(id).get();
    }
    @Override
    public Collection<Student> getByAge(Integer min, Integer max){
        return studentRepository.findByAgeBetween(min, max);
    }

    @Override
    public Student editStudent(long id, Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }


    public Faculty findFaculty(String name) {
        return  studentRepository.findByName(name).getFaculty();
    }

    @Override
    public Integer getStudentCount() {
        return  studentRepository.getStudentCount();
    }

    @Override
    public StudentAge getAverageAge() {
        return studentRepository.getAvarageStudentAge();
    }
    @Override
    public Collection<Student> getTopFiveStudent() {
        return studentRepository.getTopFiveStudent();
    }
}