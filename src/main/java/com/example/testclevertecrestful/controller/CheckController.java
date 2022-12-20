package com.example.testclevertecrestful.controller;

import com.example.testclevertecrestful.dto.CheckRequestDTO;
import com.example.testclevertecrestful.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckController {
    private final CheckService checkService;

    @Autowired
    public CheckController(CheckService checkService) {
        this.checkService = checkService;
    }

    @GetMapping("/check")
    public String getCheck(@RequestBody List<CheckRequestDTO> checkRequestDTO) {
        return checkService.getCheck(checkRequestDTO);
    }
}
