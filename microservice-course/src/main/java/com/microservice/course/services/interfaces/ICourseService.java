package com.microservice.course.services.interfaces;

import com.microservice.course.dtos.CreateCourseDTO;
import com.microservice.course.dtos.UpdateCourseDTO;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICourseService {

    List<Course> findAll() throws Exception;

    Course createCourse(CreateCourseDTO courseDTO) throws Exception;

    Course updateCourse(UpdateCourseDTO courseDTO) throws Exception;

    Course findById(Long id) throws Exception;

    void deleteCourse(Long id) throws Exception;

    StudentByCourseResponse findStudentsByIdCourse(Long idCourse) throws Exception;
}
