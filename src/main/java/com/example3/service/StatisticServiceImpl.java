package com.example3.service;

import com.example3.model.Faculty;
import com.example3.model.Student;
import com.example3.repository.FacultyRepository;
import com.example3.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

@Service
public class StatisticServiceImpl implements StatisticService{
    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;

    public StatisticServiceImpl(StudentRepository studentRepository, FacultyRepository facultyRepository) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
    }

    @Override
    public List<String> findStudentsNameFilterA() {
        return studentRepository.findAll()
                .stream()
                .map(student -> student.getName().toUpperCase())
                .filter(name -> name.startsWith("A"))
                .sorted(String::compareTo)
                .toList();
    }

    @Override
    public OptionalDouble findAverageAgeNameStudent() {
        return studentRepository.findAll()
                .stream()
                .mapToInt(Student::getAge)
                .average();
    }

    @Override
    public String getLongestFacultyName() {
        return facultyRepository.findAll()
                .stream()
                .map(Faculty::getName)
                .max(Comparator.comparingInt(String::length))
                .orElse("badRequest");
    }
}
