package com.university.contractors.repository;

import java.util.Collection;

import com.university.contractors.model.PaymentCurrent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PaymentCurrentRepository extends CrudRepository<PaymentCurrent, Long> {

    @Query(value = "SELECT * FROM Contractors.dbo.payment_current WHERE ref_contract = :contract_id ORDER BY pay_date", nativeQuery = true)
    Iterable<PaymentCurrent> getByContractIdOrderByPayDate(@Param("contract_id") Long contractId);

    @Query(value = "SELECT * FROM Contractors.dbo.payment_current WHERE ref_contract = :contract_id AND ref_payment_reason IN :payment_reasons_ids ORDER BY pay_date", nativeQuery = true)
    Iterable<PaymentCurrent> getAllDetails(@Param("contract_id") Long contractId, @Param("payment_reasons_ids") Collection<Long> paymentReasonsIds);
}
