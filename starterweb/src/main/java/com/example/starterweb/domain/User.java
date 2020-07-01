package com.example.starterweb.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/15 10:48
 */
@Data
@ToString
public class User {

    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Date created;
    private Date updated;
}
