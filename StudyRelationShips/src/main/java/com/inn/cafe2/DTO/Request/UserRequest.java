package com.inn.cafe2.DTO.Request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inn.cafe2.Entity.Expenses;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserRequest {

    private String name;

    private String lastName;

    private Integer age;

    private Character gender;

    private String login;

    private String password;

    private String email;

}
