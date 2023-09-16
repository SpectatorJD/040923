package com.example3.service;

import com.example3.model.Student;
import com.example3.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentNamePrinter implements Printer {
    private final StudentRepository studentRepository;

    public StudentNamePrinter(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void print1Task() {
        List<Student> studentList = studentRepository.findAll();

       print1(studentList.get(0));
       print1(studentList.get(1));

       new Thread(()->{
           print1(studentList.get(2));
           print1(studentList.get(3));
       }).start();

       new Thread(()->{
           print1(studentList.get(4));
           print1(studentList.get(5));
       }).start();


    }

    @Override
    public void print2Task() {
        List<Student> studentList = studentRepository.findAll();

        print2(studentList.get(0));
        print2(studentList.get(1));

        new Thread(()->{
            print2(studentList.get(2));
            print2(studentList.get(3));
        }).start();

        new Thread(()->{
            print2(studentList.get(4));
            print2(studentList.get(5));
        }).start();

    }

    private void print1(Student student){
        System.out.println(student.getName());
    }
    private synchronized void print2(Student student){
        System.out.println(student.getName());
    }
}
