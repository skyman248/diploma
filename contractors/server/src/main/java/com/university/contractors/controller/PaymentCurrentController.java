package com.university.contractors.controller;

import com.university.contractors.config.Endpoints;
import com.university.contractors.model.PaymentCurrent;
import com.university.contractors.service.PaymentService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentCurrentController extends AbstractCrudControllerBase<Long, PaymentCurrent> {

    private final PaymentService paymentService;

    public PaymentCurrentController(CrudRepository<PaymentCurrent, Long> crudRepository,
                                    PaymentService paymentService) {
        super(crudRepository);
        this.paymentService = paymentService;
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
        final PaymentCurrent createdEntity = super.create(entityToCreate);
        paymentService.recalculateFine(createdEntity);
        return createdEntity;
    }

    @Override
    @PutMapping(path = Endpoints.PAYMENT_CURRENT_BY_ID)
    PaymentCurrent update(Long id, PaymentCurrent entityToUpdateWith) {
        return super.update(id, entityToUpdateWith);
    }
}
