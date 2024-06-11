package com.microservice.course.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateCourseDTO(

        @NotNull
        Long id,
        @NotBlank
        String teacher
) {
}
