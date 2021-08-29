package com.mirac.main.ypassport.pojo;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private int rank;
}
