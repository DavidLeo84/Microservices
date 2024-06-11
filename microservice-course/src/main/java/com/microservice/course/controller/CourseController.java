package com.microservice.course.controller;


import com.microservice.course.dtos.CreateCourseDTO;
import com.microservice.course.dtos.UpdateCourseDTO;
import com.microservice.course.entities.Course;
import com.microservice.course.services.CourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course")
public class CourseController {

    private final CourseServiceImpl courseService;

    @PostMapping("/create-course")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createCourse(@RequestBody CreateCourseDTO courseDTO) throws Exception {
        Course course = courseService.createCourse(courseDTO);
        return ResponseEntity.ok(course);
    }

    @PutMapping("/update-course")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> updateCourse(@RequestBody UpdateCourseDTO courseDTO) throws Exception {
        Course course = courseService.updateCourse(courseDTO);
        return ResponseEntity.ok(course);
    }

    @GetMapping("/search-course/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> searchCourse(@PathVariable Long id) throws Exception {
        Course course = courseService.findById(id);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/delete-course/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) throws Exception {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/search-all-courses")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> searchAllCourses() throws Exception {
        List<Course> list = courseService.findAll();
        return ResponseEntity.ok(list);
    }


    @GetMapping("/search-students/{idCourse}")
    public ResponseEntity<?> findStudentsByIdCourse(@PathVariable Long idCourse) throws Exception {

        return ResponseEntity.ok(courseService.findStudentsByIdCourse(idCourse));

    }
}
