package com.microservice.student.services.interfaces;

import com.microservice.student.dtos.CreateStudentDTO;
import com.microservice.student.dtos.UpdateStudentDTO;
import com.microservice.student.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudentService {

    List<Student> findAll() throws Exception;

    Student findById(Long id) throws Exception;

    Student create(CreateStudentDTO studentDTO) throws Exception;

    Student update(UpdateStudentDTO studentDTO) throws Exception;

    void delete(Long id) throws Exception;

    List<Student> findByidCourse(Long idCourse) throws Exception;
}
