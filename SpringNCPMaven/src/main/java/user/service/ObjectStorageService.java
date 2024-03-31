package user.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ObjectStorageService {

	public String uploadFile(String bucketName, String folder, MultipartFile img);

	
	public void deleteFile(String bucketName, String objectName);


	public void deleteFileSUB(String bucketName, String folder, String imageFileName);


	public void deleteFile(String bucketName, List<String> list);
	
	
}
