package com.powernet.aws.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CreateBucketRequest;

@Repository("s3Dao")
public class S3Dao {
	@Autowired
	@Qualifier("s3Client")
	private AmazonS3 s3Client;
	
	protected List<Bucket> list(){
		return  s3Client.listBuckets();
	}
	
	protected Bucket create(String bucketName) {
		if(s3Client.doesBucketExistV2(bucketName)) {
			return null;
		}
		else {
			return s3Client.createBucket(new CreateBucketRequest(bucketName));
		}
	}
}
