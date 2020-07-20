package me.will.demowebmvc.controller;

import me.will.demowebmvc.model.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

	// events/1;name=will
	@GetMapping("/events/{id}")
	public Event getEvent(@PathVariable Long id, @MatrixVariable String name) {
		return new Event(id, name); // dto 생략
	}

	@PostMapping("/param")
	public Event getEvent2(@RequestParam Long id, @RequestParam String name) {
		return new Event(id, name);
	}

}
