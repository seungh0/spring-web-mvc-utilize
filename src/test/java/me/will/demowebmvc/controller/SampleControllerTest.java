package me.will.demowebmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class SampleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void getHelloTest() throws Exception {
		mockMvc.perform(get("/hello"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("hello"));
	}

	@Test
	void postHelloTest() throws Exception {
		mockMvc.perform(post("/hello"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("hello"));
	}

	@Test
	void getByeTest() throws Exception {
		mockMvc.perform(get("/bye"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("bye"));
	}

	@Test
	void postByeTest() throws Exception {
		mockMvc.perform(post("/bye"))
				.andDo(print())
				.andExpect(status().isMethodNotAllowed());
	}

}
