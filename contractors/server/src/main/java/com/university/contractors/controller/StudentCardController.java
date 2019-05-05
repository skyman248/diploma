package com.university.contractors.controller;

import com.university.contractors.config.Endpoints;
import com.university.contractors.controller.dto.StudentCardDto;
import com.university.contractors.service.StudentCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class StudentCardController {

    private final StudentCardService studentCardService;

    @Autowired
    public StudentCardController(StudentCardService studentCardService) {
        this.studentCardService = studentCardService;
    }

    @GetMapping(Endpoints.STUDENT_CARD)
    public StudentCardDto get(@PathVariable Long id) {
        return studentCardService.findStudentCard(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
