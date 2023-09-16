package com.example3.controller;

import com.example3.service.Printer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/printer")
public class PrinterController {
    private final Printer studentNamePrinter;

    public PrinterController(Printer studentNamePrinter) {
        this.studentNamePrinter = studentNamePrinter;
    }

    @GetMapping("/task1")
    public void print1(){
        studentNamePrinter.print1Task();
    }
    @GetMapping("/task2")
    public void print2(){
        studentNamePrinter.print2Task();
    }


}
