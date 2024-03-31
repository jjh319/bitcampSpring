package user.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import user.bean.UserImageDTO;

public interface UserUploadService {

	public void upload(List<UserImageDTO> list);

	public List<UserImageDTO> getUploadList();
	
	public UserImageDTO getUploadUser(String seq);

	public void uploadUpdate(UserImageDTO userImageDTO2);

	public void uploadUpdateSUB(UserImageDTO userImageDTO, MultipartFile img);
	
	public String getDeleteFileName(String seq);

	public void uploadDelete(String seq);

	public void uploadDeleteAll(String[] check);
}
