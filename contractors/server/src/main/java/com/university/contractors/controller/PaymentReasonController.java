package com.university.contractors.controller;

import com.university.contractors.config.Endpoints;
import com.university.contractors.model.PaymentReason;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
