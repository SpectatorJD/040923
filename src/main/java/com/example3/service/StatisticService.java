package com.example3.service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public interface StatisticService {

    List<String> findStudentsNameFilterA();
    OptionalDouble findAverageAgeNameStudent();
    String getLongestFacultyName();


}
