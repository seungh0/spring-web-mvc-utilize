package me.will.demowebmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

@Controller
public class SampleController {

	@RequestMapping("/hello") // 따로 HTTP Method를 지정하지 않으면, 기본적으로 모든 HTTP Method.
	@ResponseBody
	public String hello() {
		return "hello";
	}

	@RequestMapping(value = "bye", method = RequestMethod.GET)
	@ResponseBody
	public String bye() {
		return "bye";
	}

}
