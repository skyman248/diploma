package com.university.contractors.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.university.contractors.config.Endpoints;
import com.university.contractors.controller.dto.PaymentRecordDto;
import com.university.contractors.model.PaymentCurrent;
import com.university.contractors.repository.ContractRepository;
import com.university.contractors.repository.PaymentTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PaymentTableController {

    private final PaymentTableRepository paymentTableRepository;
    private final ContractRepository contractRepository;

    @Autowired
    public PaymentTableController(PaymentTableRepository paymentTableRepository,
                                  ContractRepository contractRepository) {
        this.paymentTableRepository = paymentTableRepository;
        this.contractRepository = contractRepository;
    }

    @GetMapping(path = Endpoints.PAYMENT_TABLE, params = "contract_id")
    public Iterable<PaymentRecordDto> get(@RequestParam(name = "contract_id") Long contractId) {

        if (!contractRepository.existsById(contractId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Contract with ID '%s' was not found", contractId));
        }

        final Iterable<PaymentCurrent> paymentCurrentIterable = paymentTableRepository.getByContractIdOrderByPayDate(contractId);
        final Map<Date, List<PaymentCurrent>> paymentCurrentGroupByPayDate = StreamSupport.stream(paymentCurrentIterable.spliterator(), Boolean.FALSE)
                .collect(Collectors.groupingBy(PaymentCurrent::getPayDate));

        return paymentCurrentGroupByPayDate.entrySet()
                .stream()
                .map(this::mapToPaymentRecordDto)
                .collect(Collectors.toList());
    }

    private PaymentRecordDto mapToPaymentRecordDto(Map.Entry<Date, List<PaymentCurrent>> dateListEntry) {
        final PaymentRecordDto paymentRecordDto = new PaymentRecordDto();
        paymentRecordDto.setDate(dateListEntry.getKey());
        paymentRecordDto.setPaymentsList(dateListEntry.getValue());
        return paymentRecordDto;
    }
}
