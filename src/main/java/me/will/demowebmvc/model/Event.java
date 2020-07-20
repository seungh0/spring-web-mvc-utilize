package me.will.demowebmvc.model;

import lombok.Getter;

@Getter
public class Event {

	private Long id;

	private String name;

	public Event(Long id, String name) {
		this.id = id;
		this.name = name;
	}

}
