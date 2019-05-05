package com.university.contractors.repository;

import com.university.contractors.model.PaymentCurrent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PaymentCurrentRepository extends CrudRepository<PaymentCurrent, Long> {

    @Query(value = "SELECT * FROM Contractors.dbo.payment_current WHERE ref_contract = :contractId ORDER BY pay_date", nativeQuery = true)
    Iterable<PaymentCurrent> getByContractIdOrderByPayDate(@Param("contractId") Long contractId);

}
