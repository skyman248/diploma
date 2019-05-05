package com.university.contractors.controller;

import com.university.contractors.config.Endpoints;
import com.university.contractors.model.PaymentCurrent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PaymentCurrentController extends AbstractCrudControllerBase<Long, PaymentCurrent> {

    public PaymentCurrentController(CrudRepository<PaymentCurrent, Long> crudRepository) {
        super(crudRepository);
    }

    @Override
    @GetMapping(path = Endpoints.PAYMENT_CURRENT_BY_ID)
    PaymentCurrent getById(Long id) {
        return super.getById(id);
    }

    @Override
    @GetMapping(path = Endpoints.PAYMENT_CURRENT)
    Iterable<PaymentCurrent> getAll() {
        return super.getAll();
    }

    @Override
    @PostMapping(path = Endpoints.PAYMENT_CURRENT)
    PaymentCurrent create(PaymentCurrent entityToCreate) {
        return super.create(entityToCreate);
    }

    @Override
    @PutMapping(path = Endpoints.PAYMENT_CURRENT_BY_ID)
    PaymentCurrent update(Long id, PaymentCurrent entityToUpdateWith) {
        return super.update(id, entityToUpdateWith);
    }

    @Override
    @DeleteMapping(path = Endpoints.PAYMENT_CURRENT_BY_ID)
    void delete(Long id) {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED);
    }
}
