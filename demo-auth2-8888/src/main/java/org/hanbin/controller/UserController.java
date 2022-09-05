package org.hanbin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public ResponseEntity getUser() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "zhangsan");
        return ResponseEntity.ok(map);
    }
}
