package com;

import com.parameter.ApplicationParameter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableConfigurationProperties(value = ApplicationParameter.class)
@EnableAutoConfiguration
public class EcopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcopsApplication.class, args);
	}

}
