package com.powernet.aws.demo;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.model.Bucket;

@Service("s3Service")
public class S3Service {
	@Autowired
	private S3Dao s3Dao;
	
	private static final Logger LOGGER = LogManager.getLogger(S3Service.class); 
	
	public void findAll() {
		List<Bucket> s3Buckets = s3Dao.list();
		
		s3Buckets.forEach((Bucket b)-> {
			LOGGER.info(b.getName());
		});
	}
	
	public Bucket createBucket() {
		return s3Dao.create("my-aws-s3-java-sdk-test-bucket");
	}
}
