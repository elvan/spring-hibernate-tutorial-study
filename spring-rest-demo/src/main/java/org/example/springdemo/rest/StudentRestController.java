package org.example.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.example.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentRestController {

  @GetMapping("/students")
  public List<Student> getStudents() {
    List<Student> students = new ArrayList<>();
    students.add(new Student("Aaron", "Wilson"));
    students.add(new Student("Blake", "Peterson"));
    students.add(new Student("Jacqueline", "Ferguson"));

    return students;
  }

}
