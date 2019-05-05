package com.university.contractors.controller;

import com.university.contractors.config.Endpoints;
import com.university.contractors.controller.dto.SearchStudent;
import com.university.contractors.controller.dto.SearchStudentResult;
import com.university.contractors.repository.SearchStudentRepository;
import org.hibernate.TransientObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
public class SearchStudentController {

    private final SearchStudentRepository searchStudentRepository;

    @Autowired
    public SearchStudentController(SearchStudentRepository searchStudentRepository) {
        this.searchStudentRepository = searchStudentRepository;
    }

    @PostMapping(path = Endpoints.SEARCH)
    public List<SearchStudentResult> search(@RequestBody SearchStudent searchStudent) {
        try {
            return searchStudentRepository.search(searchStudent);
        } catch (RuntimeException exception) {
            if (isCausedByTransientObjectException(exception)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "IDs of all entities should be specified to execute s");
            }
            throw exception;
        }
    }

    private boolean isCausedByTransientObjectException(RuntimeException exception) {
        Throwable currentCause = exception;
        while (Objects.nonNull(currentCause)) {
            if (currentCause instanceof TransientObjectException) {
                return true;
            }

            currentCause = currentCause.getCause();
        }
        return false;
    }
}
