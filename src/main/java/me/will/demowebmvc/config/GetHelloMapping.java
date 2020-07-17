package me.will.demowebmvc.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * RetentionPolicy
 *
 * Class -> 컴파일 되어도 .class 파일에 애노테이션 정보 남아있음. but 클래스를 로딩하는 순간 사라짐 (클래스 로더가 바이트 코드를 읽어오는 순간)
 * Runtime -> 런타임시에도 애노테이션 정보 유지
 * Source -> 소스코드에서만 애노테이션 유지 (주석 같은)
 */

@Documented // Javadoc 을 만들때, 애노테이션 정보도 문서화에 포함됨.
@Target(ElementType.METHOD) // 메소드에 사용할 수 있는 Annotation
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.GET, value = "/hello")
public @interface GetHelloMapping {
}
