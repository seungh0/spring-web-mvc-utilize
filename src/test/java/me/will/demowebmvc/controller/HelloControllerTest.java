package me.will.demowebmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class HelloControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void getEvent() throws Exception {
		this.mockMvc.perform(get("/events/1;name=will"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("id").value(1))
				.andExpect(jsonPath("name").value("will"));
	}

	@Test
	void getEvent2() throws Exception {
		this.mockMvc.perform(post("/param")
				.param("id", "10")
				.param("name", "will"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("id").value(10))
				.andExpect(jsonPath("name").value("will"));
	}

}