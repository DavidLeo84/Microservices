package com.microservice.student.controller;

import com.microservice.student.dtos.CreateStudentDTO;
import com.microservice.student.dtos.UpdateStudentDTO;
import com.microservice.student.entities.Student;
import com.microservice.student.services.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create-student")
    public ResponseEntity<?> createStudent(@RequestBody CreateStudentDTO studentDTO) throws Exception {
        Student student = studentService.create(studentDTO);
        return ResponseEntity.ok(student);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/search/{id}")
    public ResponseEntity<?> searchStudent(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PutMapping("/update-student")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> updateStudent(@RequestBody UpdateStudentDTO studentDTO) throws Exception {
        Student student = studentService.update(studentDTO);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/search-all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> searchStudents() throws Exception {
        return ResponseEntity.ok(studentService.findAll());
    }

    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) throws Exception {
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/search-by-course/{idCourse}")
    public ResponseEntity<List<Student>> findByIdCourse(@PathVariable Long idCourse) throws Exception {
        return ResponseEntity.ok(studentService.findByidCourse(idCourse));
    }

}
