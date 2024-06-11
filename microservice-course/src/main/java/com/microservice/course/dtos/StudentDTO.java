package com.microservice.course.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StudentDTO(

        @NotBlank
        String name,
        @NotBlank
        String lastname,
        @NotBlank
        String email,
        @NotNull
        Long courseId
) {
}
