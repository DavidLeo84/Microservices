package com.microservice.course.services;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dtos.CreateCourseDTO;
import com.microservice.course.dtos.StudentDTO;
import com.microservice.course.dtos.UpdateCourseDTO;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.persistence.CourseRepo;
import com.microservice.course.services.interfaces.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private StudentClient studentClient;

    @Override
    public List<Course> findAll() throws Exception {
        return (List<Course>) courseRepo.findAll();
    }

    @Override
    public Course createCourse(CreateCourseDTO courseDTO) throws Exception {
        Course course = Course.builder()
                .name(courseDTO.name())
                .teacher(courseDTO.teacher())
                .build();
        courseRepo.save(course);
        return course;
    }

    @Override
    public Course updateCourse(UpdateCourseDTO courseDTO) throws Exception {
        Course course = courseRepo.findById(courseDTO.id()).orElseThrow();
        course.setTeacher(courseDTO.teacher());
        courseRepo.save(course);
        return course;
    }

    @Override
    public Course findById(Long id) throws Exception {
        return courseRepo.findById(id).orElseThrow();
    }

    @Override
    public void deleteCourse(Long id) throws Exception {
        Course course = courseRepo.findById(id).orElseThrow();
        courseRepo.delete(course);
    }

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) throws Exception {

        Course course = courseRepo.findById(idCourse).orElse(new Course());
        List<StudentDTO> studentDTOList = studentClient.findAllStudentByCourse(idCourse);
        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}
