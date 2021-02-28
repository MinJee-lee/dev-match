package com.example.demo.common.controller;

import com.example.demo.common.service.dao.SystemCheckDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/systemCheck")
@RequiredArgsConstructor
public class SystemCheck {

    private final SystemCheckDAO systemCheckDAO;

    @GetMapping("/dbCheck")
    public ResponseEntity<Object> dbCheck() {
        return ResponseEntity.ok(systemCheckDAO.selectDatabaseInfo());
    }
}
