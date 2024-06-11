package com.microservice.course.dtos;

import jakarta.validation.constraints.NotBlank;

public record CreateCourseDTO(

        @NotBlank
        String name,
        @NotBlank
        String teacher
) {
}
