package org.example.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.example.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

  // add an exception handle
  @ExceptionHandler
  public ResponseEntity<StudentErrorResponse> handleException(
    StudentNotFoundException exc
  ) {
    StudentErrorResponse error = new StudentErrorResponse();
    error.setStatus(HttpStatus.NOT_FOUND.value());
    error.setMessage(exc.getMessage());
    error.setTimestamp(System.currentTimeMillis());

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

}
