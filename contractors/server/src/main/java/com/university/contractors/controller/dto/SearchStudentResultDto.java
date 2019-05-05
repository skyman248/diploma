package com.university.contractors.controller.dto;

import com.university.contractors.model.Contract;
import com.university.contractors.model.Country;
import com.university.contractors.model.Direction;
import com.university.contractors.model.EducationForm;
import com.university.contractors.model.EducationLevel;
import com.university.contractors.model.Faculty;
import com.university.contractors.model.Student;

public class SearchStudentResultDto {

    private Student student;
    private Contract contract;
    private Country country;
    private Integer course;
    private EducationForm educationForm;
    private Faculty faculty;
    private Direction direction;
    private EducationLevel educationLevel;

    // Added for compatibility with Hibernate
    public SearchStudentResultDto(Contract contract) {
        this.student = contract.getStudent();
        this.contract = contract;
        this.country = student.getCountry();
        this.course = contract.getCourse();
        this.educationForm = contract.getEducationForm();
        this.faculty = contract.getDirection().getFaculty();
        this.direction = contract.getDirection();
        this.educationLevel = contract.getEducationLevel();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public EducationForm getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(EducationForm educationForm) {
        this.educationForm = educationForm;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }
}
