package com.example;

import com.example.dao.CarRepository;
import com.example.model.Car;
import lombok.extern.slf4j.Slf4j;
import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.stream.Stream;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@Slf4j
@EnableSwagger2
@EnableWebSecurity
//@ComponentScan
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		CarRepository carRepository = ctx.getBean(CarRepository.class);
		Stream.of(new Car("audi", 333, "A3"),new Car("bmw", 443, "320d")).forEach(s -> carRepository.save(s));
	}
	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("greetings")
				//.apiInfo(apiInfo())
				.select()
				.paths(regex("/api.*"))
				.build();
	}

	@Bean
	ServletRegistrationBean h2servletRegistration(){
		ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}
}
