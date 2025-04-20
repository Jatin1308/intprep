package com.kafka.kafkaconsumer.model;


public class User {

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(String id, String company, String name) {
        this.id = id;
        this.company = company;
        this.name = name;
    }

    String id;
    String name;
    String company;
}
