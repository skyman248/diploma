package com.university.contractors.controller.dto;

import java.util.List;

import com.university.contractors.model.PaymentCurrent;

public class PaymentRecordDto {

    private String monthName;
    private Integer year;

    private List<PaymentCurrent> paymentsList;

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<PaymentCurrent> getPaymentsList() {
        return paymentsList;
    }

    public void setPaymentsList(List<PaymentCurrent> paymentsList) {
        this.paymentsList = paymentsList;
    }
}
