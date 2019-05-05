package com.university.contractors.repository;

import com.university.contractors.model.PaymentType;
import org.springframework.data.repository.CrudRepository;

public interface PaymentTypeRepository extends CrudRepository<PaymentType, Long> {
}
