package br.com.renato;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String message = "Hello, %s";

    private static AtomicLong counter = new AtomicLong();
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam (value = "name", defaultValue = "World") String text) {
        return new Greeting(counter.incrementAndGet(), String.format(message, text));
    }
}
