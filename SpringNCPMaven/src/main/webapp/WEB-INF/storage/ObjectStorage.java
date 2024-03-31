package user.bean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Component
public class ObjectStorage {
	
	public void input(File file,String objectName) {
	String endPoint = "https://kr.object.ncloudstorage.com";
	String regionName = "kr-standard";
	String accessKey = "C0CA07CEB6978F3F9BD0";
	String secretKey = "CC1A95374F794E3B19969B760D3CB90A561A76DD";
	
	// S3 client
	AmazonS3 s3 = AmazonS3ClientBuilder.standard()
	    .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endPoint, regionName))
	    .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
	    .build();

	String bucketName = "bitcamp-6th-bucket-106";
	
	
	
	
	try {
	    s3.putObject(bucketName, objectName, file);
	    System.out.format("Object %s has been created.\n", objectName);
	} catch (AmazonS3Exception e) {
	    e.printStackTrace();
	} catch(SdkClientException e) {
	    e.printStackTrace();
	}
	
	}
}
