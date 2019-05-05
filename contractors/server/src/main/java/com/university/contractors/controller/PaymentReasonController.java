package com.university.contractors.controller;

import com.university.contractors.config.Endpoints;
import com.university.contractors.model.PaymentReason;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PaymentReasonController extends AbstractCrudControllerBase<Long, PaymentReason> {

    public PaymentReasonController(CrudRepository<PaymentReason, Long> crudRepository) {
        super(crudRepository);
    }

    @Override
    @GetMapping(path = Endpoints.PAYMENT_REASON_BY_ID)
    public PaymentReason getById(@PathVariable Long id) {
        return super.getById(id);
    }

    @Override
    @GetMapping(path = Endpoints.PAYMENT_REASONS)
    public Iterable<PaymentReason> getAll() {
        return super.getAll();
    }

    @Override
    @PostMapping(path = Endpoints.PAYMENT_REASONS)
    public PaymentReason create(@RequestBody PaymentReason entityToCreate) {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    @PutMapping(path = Endpoints.PAYMENT_REASON_BY_ID)
    public PaymentReason update(@PathVariable Long id, @RequestBody PaymentReason entityToUpdateWith) {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    @DeleteMapping(path = Endpoints.PAYMENT_REASON_BY_ID)
    public void delete(@PathVariable Long id) {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED);
    }
}
