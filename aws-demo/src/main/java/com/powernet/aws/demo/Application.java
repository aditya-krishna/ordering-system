package com.powernet.aws.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{
	@Autowired
	private S3Service s3Service;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	private void printS3Buckets() {
		s3Service.findAll();
	}

	@Override
	public void run(String... arg0) throws Exception {
		s3Service.createBucket();
		printS3Buckets();
	}
}
