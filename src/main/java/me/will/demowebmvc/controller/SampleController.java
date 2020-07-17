package me.will.demowebmvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * HTTP Method
 *
 * 1. GET
 * : 클라이언트가 서버의 리소스를 요청할 때 사용.
 * - 캐싱할 수 있다.
 * - 브라우저 기록 남음, 북마크 가능
 * - idemponent
 *
 * 2. POST
 * : 클라이언트가 서버의 리소스를 수정하거나 새로 만들 때 사용.
 * - 캐싱 X
 * - 브라우저 기록 X, 북마크 X
 *
 * 3. PUT
 * : URL에 해당하는 데이터를 새로 만들거나 수정할 때 사용.
 * - idemponent
 *
 * * POST vs PUT
 * POST의 URI는 보내는 데이터를 처리할 리소스를 지칭.
 * PUT의 URI는 보내는 데이터에 해당하는 리소스를 지칭.
 *
 * 4. PATCH
 * : PUT과 비슷하지만, 기존 엔티티와 새 데이터의 차이점만 보낸다는 차이 존재.
 * - idemponent
 *
 * 5. DELETE
 * : URI에 해당하는 리소스 삭제
 * - idemponent
 */


/**
 * HEAD, OPTIONS 요청 처리
 *
 * HEAD
 * * Get 요청과 동일하지만, 응답 본문을 받아오지 않고, 응답 헤더만 받아온다.
 *
 * OPTIONS
 * * 사용할 수 있는  Http Method 제공
 * * 서버 또는 특정 리소스가 제공하는 기능을 확인 할 수 있다.
 */
@RestController
public class SampleController {

	@RequestMapping("/hello") // 따로 HTTP Method를 지정하지 않으면, 기본적으로 모든 HTTP Method.
	public String hello() {
		return "hello";
	}

	@RequestMapping(value = "bye", method = RequestMethod.GET)
	public String bye() {
		return "bye";
	}

	@RequestMapping(
			value = "/helloJson",
			consumes = MediaType.APPLICATION_JSON_VALUE, // Content-Type
			produces = MediaType.APPLICATION_JSON_VALUE // Accept
	)
	public String helloJson() {
		return "helloJson";
	}

	@GetMapping(value = "/header", headers = HttpHeaders.FROM)
	public String headerTest() {
		return "header";
	}

	@GetMapping(value = "/param", params = "name")
	public String param() {
		return "param";
	}

}
