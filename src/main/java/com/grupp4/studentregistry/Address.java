package com.grupp4.studentregistry;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private String Country;
    private String city;
    private String postCode;
}