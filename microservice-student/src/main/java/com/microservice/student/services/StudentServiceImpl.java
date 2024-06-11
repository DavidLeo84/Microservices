package com.microservice.student.services;

import com.microservice.student.dtos.CreateStudentDTO;
import com.microservice.student.dtos.UpdateStudentDTO;
import com.microservice.student.entities.Student;
import com.microservice.student.persistence.StudentRepo;
import com.microservice.student.services.interfaces.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> findAll() throws Exception {
        return (List<Student>) studentRepo.findAll();
    }

    @Override
    public Student findById(Long id) throws Exception {
        return studentRepo.findById(id).orElseThrow();
    }

    @Override
    public Student create(CreateStudentDTO studentDTO) throws Exception {
        Student student = Student.builder()
                .name(studentDTO.name())
                .lastname(studentDTO.lastname())
                .email(studentDTO.email())
                .build();
        studentRepo.save(student);
        return student;
    }

    @Override
    public Student update(UpdateStudentDTO studentDTO) throws Exception {
       Student student =  studentRepo.findById(studentDTO.id()).orElseThrow();
       student.setName(studentDTO.name());
       student.setLastname(studentDTO.lastname());
       student.setEmail(studentDTO.email());
       student.setCourseId(studentDTO.courseId());
       studentRepo.save(student);
       return student;
    }

    @Override
    public void delete(Long id) throws Exception {
        Student student = studentRepo.findById(id).orElseThrow();
        studentRepo.delete(student);
    }

    @Override
    public List<Student> findByidCourse(Long idCourse) throws Exception {
        return studentRepo.findAllByCourseId(idCourse);
    }
}
