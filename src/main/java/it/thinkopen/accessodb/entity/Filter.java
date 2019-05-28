package it.thinkopen.accessodb.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;

public class Filter {
    private String name;
    private String value;

    public Filter() {
    }

    public Filter(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
