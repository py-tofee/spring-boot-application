package com.example.hello;

import com.example.hello.world.Hello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by yao.peng on 2017/3/1.
 */
@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
    @RequestMapping("/hello")
    public Object hello(@RequestParam(value = "name", defaultValue = "world") String name) {
        Hello hello=new Hello();
        return hello.getName();
    }
}