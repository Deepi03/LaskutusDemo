package com.free.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.free.demo.dto.PersonalIdentity;
import com.free.demo.service.SSNValidateService;

@RestController
public class SSNController {

    @Autowired
    private SSNValidateService service;

    @PostMapping("/validate_ssn")
    public Boolean validateSSN(@RequestBody PersonalIdentity personalIdentity) {

        return service.validateSSN(personalIdentity);

    }
}
