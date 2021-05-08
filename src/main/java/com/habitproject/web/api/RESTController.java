package com.habitproject.web.api;

import com.habitproject.service.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RESTController {

    private static final String template = "Hello,%s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/TestEntity")
    public Test test(@RequestParam(value = "category", defaultValue = "Test") String category) {
        return new Test(counter.incrementAndGet(), String.format(template, category));
    }
}
