package br.com.renato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Startup {
	public static void main(String[] args) {
		System.out.println("SKLDSADJKLAJKLD");
		SpringApplication.run(Startup.class, args);
	}
}
