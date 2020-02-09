package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {

    @GetMapping(value = "/deep-link-test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SomeResponse deepLink() {
        return new SomeResponse("OK");
    }

}

