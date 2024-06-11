package com.microservice.student.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateStudentDTO(

        @NotBlank
        String name,
        @NotBlank
        String lastname,
        @Email
        String email
) {
}
