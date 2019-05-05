package com.university.contractors.controller;

import com.university.contractors.config.Endpoints;
import com.university.contractors.model.PaymentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentFormController extends AbstractCrudControllerBase<Long, PaymentForm> {

    @Autowired
    public PaymentFormController(CrudRepository<PaymentForm, Long> crudRepository) {
        super(crudRepository);
    }

    @Override
    @GetMapping(path = Endpoints.PAYMENT_FORM_BY_ID)
    PaymentForm getById(Long id) {
        return super.getById(id);
    }

    @Override
    @GetMapping(path = Endpoints.PAYMENT_FORM)
    Iterable<PaymentForm> getAll() {
        return super.getAll();
    }
}
