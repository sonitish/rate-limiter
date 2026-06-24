package io.github.sonitish.ratelimiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.sonitish.ratelimiter.algorithms.TokenBucketAlgorithm;

@SpringBootApplication
public class RateLimiterApplication {

	public static void main(String[] args) {
		System.out.println("Starting App: ");

		Thread refillThread = new Thread(() -> {
			while (true) {
				System.out.println("Refilling bucket");
				TokenBucketAlgorithm.refillBucket();
			}
		});

		refillThread.start(); // important

		SpringApplication.run(RateLimiterApplication.class, args);
	}
}