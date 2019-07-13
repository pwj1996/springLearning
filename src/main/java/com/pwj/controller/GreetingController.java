package com.pwj.controller;

import com.pwj.domain.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

//代替@Controller和@Respond
@RestController
public class GreetingController {
    private static final String template = "Hello, $s1";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world")String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
