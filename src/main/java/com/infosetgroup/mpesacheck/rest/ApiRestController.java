package com.infosetgroup.mpesacheck.rest;

import com.infosetgroup.mpesacheck.dto.CheckRequest;
import com.infosetgroup.mpesacheck.dto.CheckRequestV2;
import com.infosetgroup.mpesacheck.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/rest")
public class ApiRestController {

    @Autowired
    private ProcessService processService;

    @PostMapping(value = "/v1/am/check", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> check(@RequestBody CheckRequest request) {
        System.out.println(request);
        try {
            String username = request.getUsername();
            String password = request.getPassword();
            // Data
            String response = processService.checkTransaction(username, password, request.getTransactionId(), request.getTransactionDate());
            System.out.println(response);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception exception) {
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(exception, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/v1/am/checkv2", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> checkV2(@RequestBody CheckRequestV2 request) {
        System.out.println(request);
        try {
            String username = request.getUsername();
            String password = request.getPassword();
            // Data
            String response = processService.checkTransactionv2(username, password, request.getTransactionId(), request.getTransactionDate(), request.getUrl());
            System.out.println(response);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception exception) {
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(exception, HttpStatus.OK);
        }
    }
}
