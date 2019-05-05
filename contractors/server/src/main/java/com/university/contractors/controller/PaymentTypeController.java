package com.university.contractors.controller;

import com.university.contractors.config.Endpoints;
import com.university.contractors.model.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentTypeController extends AbstractCrudControllerBase<Long, PaymentType> {

    @Autowired
    public PaymentTypeController(CrudRepository<PaymentType, Long> crudRepository) {
        super(crudRepository);
    }

    @Override
    @GetMapping(Endpoints.PAYMENT_TYPE_BY_ID)
    PaymentType getById(Long id) {
        return super.getById(id);
    }

    @Override
    @GetMapping(Endpoints.PAYMENT_TYPE)
    Iterable<PaymentType> getAll() {
        return super.getAll();
    }
}
