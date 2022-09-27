package com.free.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.free.demo.dto.PersonalIdentity;
import com.free.demo.dto.SSNValidationResponse;
import com.free.demo.service.SSNValidateService;

@RestController
public class SSNController {

    @Autowired
    private SSNValidateService service;

    @PostMapping("/validate_ssn")
    public ResponseEntity<SSNValidationResponse> validateSSN(@RequestBody PersonalIdentity personalIdentity) {
        return ResponseEntity.ok(new SSNValidationResponse(service.validateSSN(personalIdentity)));
    }
}
