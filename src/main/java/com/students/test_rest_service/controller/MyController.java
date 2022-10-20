package com.students.test_rest_service.controller;

import com.students.test_rest_service.model.Request;
import com.students.test_rest_service.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MyController {
    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@RequestBody Request request) {

        log.info("Входящий request : "+ request);
        Response response = Response.builder().uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();

        log.info("Исходящий response : "+ response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
