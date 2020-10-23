package com.smec.template.exceprion;


import org.springframework.http.HttpStatus;

public class ExceptionMsg {

    private HttpStatus status;
    private String businessCode;
    private String message;
    private String data;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ExceptionMsg(HttpStatus status, String businessCode, String message, String data) {
        this.status = status;
        this.businessCode = businessCode;
        this.message = message;
        this.data = data;
    }

    public ExceptionMsg() {
    }
}
