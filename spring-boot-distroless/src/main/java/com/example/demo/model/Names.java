package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Names {

    public Names(String first, String last){
        this.firstName = first;
        this.lastName = last;
    }

    public String firstName;

    public String lastName;

}
