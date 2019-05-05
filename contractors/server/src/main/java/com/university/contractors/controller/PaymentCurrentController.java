package com.university.contractors.controller;

import com.university.contractors.config.Endpoints;
import com.university.contractors.model.Contract;
import com.university.contractors.model.PaymentCurrent;
import com.university.contractors.repository.ContractRepository;
import com.university.contractors.service.PaymentService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PaymentCurrentController extends AbstractCrudControllerBase<Long, PaymentCurrent> {

    private final PaymentService paymentService;
    private final ContractRepository contractRepository;

    public PaymentCurrentController(CrudRepository<PaymentCurrent, Long> crudRepository,
                                    PaymentService paymentService,
                                    ContractRepository contractRepository) {
        super(crudRepository);
        this.paymentService = paymentService;
        this.contractRepository = contractRepository;
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
        final Long contractId = entityToCreate.getContract().getId();
        final Contract contract = contractRepository.findById(contractId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Contract with ID '%s' was not found", contractId)));

        if (!contract.getActive()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Payment cannot be added to inactive contract.");
        }

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
