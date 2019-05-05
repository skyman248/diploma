package com.university.contractors.repository;

import com.university.contractors.model.PaymentForm;
import org.springframework.data.repository.CrudRepository;

public interface PaymentFormRepository extends CrudRepository<PaymentForm, Long> {
}
