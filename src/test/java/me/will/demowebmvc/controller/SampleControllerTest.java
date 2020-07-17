package me.will.demowebmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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

	@Test
	void 같은_Content_Type을_넘기는_경우() throws Exception {
		mockMvc.perform(get("/helloJson")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void 다른_Content_Type을_넘기는경우_예외가_발생한다() throws Exception {
		mockMvc.perform(get("/helloJson")
				.contentType(MediaType.APPLICATION_XML_VALUE))
				.andDo(print())
				.andExpect(status().isUnsupportedMediaType());
	}

	@Test
	void 다른_Accept_를_넘기는경우_예외가_발생한다() throws Exception {
		mockMvc.perform(get("/helloJson")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_XML_VALUE))
				.andDo(print())
				.andExpect(status().isNotAcceptable());
	}

	@Test
	void 헤더를_넘기는경우() throws Exception {
		mockMvc.perform(get("/header")
				.header(HttpHeaders.FROM, "localhost"))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void 다른_헤더를_넘기는경우_예외가_발생한다() throws Exception {
		mockMvc.perform(get("/header")
				.header(HttpHeaders.AUTHORIZATION, "test"))
				.andDo(print())
				.andExpect(status().isNotFound());
	}

	@Test
	void 파라미터을_넘기는경우() throws Exception {
		mockMvc.perform(get("/param")
				.param("name", "name"))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void 파라미터를_넘기지_않는경우_예외가_발생한다() throws Exception {
		mockMvc.perform(get("/param"))
				.andDo(print())
				.andExpect(status().isBadRequest());
	}

}
