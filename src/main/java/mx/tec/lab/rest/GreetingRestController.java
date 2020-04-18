package mx.tec.lab.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RestController;

import mx.tec.lab.dto.Greeting;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class GreetingRestController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	private static final String byeTemplate = "Goodbye, %s";
	
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	@RequestMapping("/goodbye")
	public Greeting goodbye(@RequestParam(value = "name", defaultValue = "user") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(byeTemplate, name));
	}
	
}
