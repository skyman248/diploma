package com.university.contractors.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PaymentCurrent implements IdEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ref_contract")
    private Contract contract;

    private Float sum;
    private Float sumUsd;

    private Date payDate;
    private Date regDate;

    @ManyToOne
    @JoinColumn(name = "ref_payment_reason")
    private PaymentReason paymentReason;

    @ManyToOne
    @JoinColumn(name = "ref_payment_form")
    private PaymentForm paymentForm;

    private String paymentBasis;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }

    public Float getSumUsd() {
        return sumUsd;
    }

    public void setSumUsd(Float sumUsd) {
        this.sumUsd = sumUsd;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public PaymentReason getPaymentReason() {
        return paymentReason;
    }

    public void setPaymentReason(PaymentReason paymentReason) {
        this.paymentReason = paymentReason;
    }

    public PaymentForm getPaymentForm() {
        return paymentForm;
    }

    public void setPaymentForm(PaymentForm paymentForm) {
        this.paymentForm = paymentForm;
    }

    public String getPaymentBasis() {
        return paymentBasis;
    }

    public void setPaymentBasis(String paymentBasis) {
        this.paymentBasis = paymentBasis;
    }
}
