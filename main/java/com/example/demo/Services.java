package com.example.demo;

import java.sql.Date;
import java.time.LocalDateTime;

public class Services {

    public String code;
    public String name;
    public String ally;
    public LocalDateTime activation_date;
    public LocalDateTime inactivation_date;
    public String status;

    public Services(String code, String name, String ally, LocalDateTime activation_date, LocalDateTime inactivation_date, String status) {
        this.code = code;
        this.name = name;
        this.ally = ally;
        this.activation_date = activation_date;
        this.inactivation_date = inactivation_date;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlly() {
        return ally;
    }

    public void setAlly(String ally) {
        this.ally = ally;
    }

    public LocalDateTime getActivation_date() {
        return activation_date;
    }

    public void setActivation_date(LocalDateTime activation_date) {
        this.activation_date = activation_date;
    }

    public LocalDateTime getInactivation_date() {
        return inactivation_date;
    }

    public void setInactivation_date(LocalDateTime inactivation_date) {
        this.inactivation_date = inactivation_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}