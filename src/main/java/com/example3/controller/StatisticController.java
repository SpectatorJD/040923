package com.example3.controller;

import com.example3.service.StatisticService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.OptionalDouble;

@RestController
@RequestMapping("/statistic")
public class StatisticController {
    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService){
        this.statisticService = statisticService;
    }
    @GetMapping("/start-a")
    public List<String> getStudentsNameFilterA(){
        return statisticService.findStudentsNameFilterA();
    }
    @GetMapping("/avg-name")
    public OptionalDouble findAverageAgeNameStudent(){
        return statisticService.findAverageAgeNameStudent();
    }
    @GetMapping("/longest-faculty")
    public String getLongestFacultyName(){
        return statisticService.getLongestFacultyName();
    }
}
