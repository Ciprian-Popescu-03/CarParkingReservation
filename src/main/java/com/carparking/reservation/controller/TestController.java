package com.carparking.reservation.controller;

import com.carparking.reservation.entity.TestEntity;
import com.carparking.reservation.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestRepository testRepository;

    @PostMapping
    public TestEntity addTestEntity(@RequestBody String name) {
        TestEntity entity = new TestEntity();
        entity.setName(name);
        return testRepository.save(entity);
    }

    @GetMapping
    public List<TestEntity> getAllTestEntities() {
        return testRepository.findAll();
    }
}
