package org.example.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.example.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentRestController {

  private List<Student> students = new ArrayList<>();

  // define @PostConstruct to load the student data ... only once!
  @PostConstruct
  public void loadData() {
    students.add(new Student("Aaron", "Wilson"));
    students.add(new Student("Blake", "Peterson"));
    students.add(new Student("Jacqueline", "Ferguson"));
  }

  @GetMapping("/students")
  public List<Student> getStudents() {
    return students;
  }

  @GetMapping("/students/{studentId}")
  public Student getStudent(@PathVariable int studentId) {
    // check the studentId against list size
    if ((studentId >= students.size()) || (studentId < 0)) {
      throw new StudentNotFoundException("Student id not found: " + studentId);
    }

    return students.get(studentId);
  }

}
