package io.github.sonitish.ratelimiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RateLimiterApplication {

	public static void main(String[] args) {
		System.out.println("Starting App: ");
		SpringApplication.run(RateLimiterApplication.class, args);
	}

}
