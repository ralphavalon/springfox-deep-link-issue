package com.example.demo.controller;

public class SomeResponse {
    String status;

    SomeResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}