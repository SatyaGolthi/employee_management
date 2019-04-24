package com.cg.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//satya  golthi

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.*"})
public class MyMain {

		public static void main(String[] args) {
			SpringApplication.run(MyMain.class, args);

		}

}
