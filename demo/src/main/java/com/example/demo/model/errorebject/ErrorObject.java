package com.example.demo.model.errorebject;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorObject {

    private int httpstatus;

    private String message;

    private Date timestamp;
}
