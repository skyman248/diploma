package com.university.contractors.controller.dto;

import java.util.List;

import com.university.contractors.model.Contract;
import com.university.contractors.model.Order;
import com.university.contractors.model.Student;

public class StudentCard {

    private Student student;
    private Contract currentContract;
    private List<Order> orders;
    private List<Contract> contracts;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Contract getCurrentContract() {
        return currentContract;
    }

    public void setCurrentContract(Contract currentContract) {
        this.currentContract = currentContract;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
