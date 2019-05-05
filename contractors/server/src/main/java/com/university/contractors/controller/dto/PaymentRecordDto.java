package com.university.contractors.controller.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.university.contractors.model.PaymentCurrent;

public class PaymentRecordDto {

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date date;
    private List<PaymentCurrent> paymentsList;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<PaymentCurrent> getPaymentsList() {
        return paymentsList;
    }

    public void setPaymentsList(List<PaymentCurrent> paymentsList) {
        this.paymentsList = paymentsList;
    }
}
