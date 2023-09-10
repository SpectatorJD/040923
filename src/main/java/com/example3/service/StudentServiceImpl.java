package com.example3.service;


import com.example3.model.Faculty;
import com.example3.model.Student;
import com.example3.model.StudentAge;
import com.example3.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentServiceImpl implements StudentService{


    private final StudentRepository studentRepository;
    Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent (Student student){
        logger.info("Was invoked method for to add student");
        return studentRepository.save(student);
    }

    public Student findStudent(long id){
        logger.info("Was invoked method for to find student by id");
        return studentRepository.findById(id).get();
    }
    @Override
    public Collection<Student> getByAge(Integer min, Integer max){
        logger.info("Was invoked method for to get student by age");
        return studentRepository.findByAgeBetween(min, max);
    }

    @Override
    public Student editStudent(long id, Student student) {
        logger.info("Was invoked method for to edit student");
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long id) {
        logger.info("Was invoked method for to delete student by id");
        studentRepository.deleteById(id);
    }


    public Faculty findFaculty(String name) {
        logger.info("Was invoked method for to find student by faculty");
        return  studentRepository.findByName(name).getFaculty();
    }

    @Override
    public Integer getStudentCount() {
        return  studentRepository.getStudentCount();
    }

    @Override
    public StudentAge getAverageAge() {
        logger.info("Was invoked method for to get students by average age");
        return studentRepository.getAvarageStudentAge();
    }
    @Override
    public Collection<Student> getTopFiveStudent() {
        logger.info("Was invoked method for to get top five students");
        return studentRepository.getTopFiveStudent();
    }
}