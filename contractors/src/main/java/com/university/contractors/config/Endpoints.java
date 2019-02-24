package com.university.contractors.config;

public interface Endpoints {

    String API_PREFIX = "/api";
    String API_VERSION_PREFIX = "/v1";
    String ENDPOINTS_PREFIX = API_PREFIX + API_VERSION_PREFIX;

    String LOGIN = ENDPOINTS_PREFIX + "/login";
    String SIGN_UP = ENDPOINTS_PREFIX + "/signUp";

    String ENTITY_PREFIX = ENDPOINTS_PREFIX + "/entity";
    String ID_PARAMETER = "/{id}";

    String STUDENTS = ENTITY_PREFIX + "/students";
    String STUDENT_BY_ID = STUDENTS + ID_PARAMETER;

    String COUNTRIES = ENTITY_PREFIX + "/countries";
    String COUNTRY_BY_ID = COUNTRIES + ID_PARAMETER;
}
