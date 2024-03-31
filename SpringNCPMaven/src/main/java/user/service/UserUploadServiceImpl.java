package user.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import user.bean.UserImageDTO;
import user.dao.UserUploadDAO;

@Service
public class UserUploadServiceImpl implements UserUploadService {
	@Autowired
	private UserUploadDAO userUploadDAO;

	@Autowired
	private ObjectStorageService objectStorageService;
	
	@Autowired
	private HttpSession session;
	
	private String bucketName = "bitcamp-6th-bucket-106";
	
	@Override
	public void upload(List<UserImageDTO> list) {
		userUploadDAO.upload(list);
	}

	@Override
	public List<UserImageDTO> getUploadList() {
		return userUploadDAO.getUploadList();
	}

	@Override
	public UserImageDTO getUploadUser(String seq) {
		
		return userUploadDAO.getUploadUser(Integer.parseInt(seq));
	}

	@Override
	public void uploadUpdate(UserImageDTO userImageDTO2) {
		// TODO Auto-generated method stub
		
		userUploadDAO.uploadUpdate(userImageDTO2);
		
	}

	@Override
	public String getDeleteFileName(String seq) {
		
		return userUploadDAO.getDeleteFileName(Integer.parseInt(seq));
	}

	@Override
	public void uploadDelete(String seq) {
		userUploadDAO.uploadDelete(Integer.parseInt(seq));
		
	}

	@Override
	public void uploadUpdateSUB(UserImageDTO userImageDTO, MultipartFile img) {
		
		String filePath = session.getServletContext().getRealPath("WEB-INF/storage");
		System.out.println("실제폴더 = " + filePath);
		
		//DB에서 SEQ의 해당하는 imageFileName을 꺼내와서 Object Storage(NCP)이미지 삭제
		//Object Storage(NCP)는 이미지를 덮어쓰지 못한다.
		String imageFileName = userUploadDAO.getImageFileName(userImageDTO.getSeq());
	    System.out.println("imageFileName = " + imageFileName);
	    
	    //Object Storage(NCP) 파일 삭제
	    objectStorageService.deleteFileSUB(bucketName,"storage/",imageFileName);
	    //Object Storage(NCP) 파일 업로드
	    imageFileName = objectStorageService.uploadFile(bucketName,"storage/",img);
	    
	    File file = new File(filePath,imageFileName);
	    
	    try {
			img.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		userImageDTO.setImageFileName(imageFileName);
		userImageDTO.setImageOriginalName(img.getOriginalFilename());
		
		userUploadDAO.uploadUpdateSUB(userImageDTO);
	    
	}

	@Override
	public void uploadDeleteAll(String[] check) {
		List<String> list = new ArrayList<>();
		//DB에서 SEQ에 해당하는 imageFileName 꺼내와서 list에 담는다.
		for(String c : check) {
			String imageFileName = userUploadDAO.getImageFileName(Integer.parseInt(c));
			list.add(imageFileName);
		}
		//Object Storage(NCP) 삭제
		objectStorageService.deleteFile(bucketName, list);
		
		List<Integer> listSeq = new ArrayList<>();
		for(String c : check) {
			listSeq.add(Integer.parseInt(c));
		}
		//DB 삭제
		userUploadDAO.uploadDeleteAll(listSeq);
		
		
	}
}
