package user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import user.bean.UserImageDTO;

@Mapper
public interface UserUploadDAO {

	public void upload(List<UserImageDTO> list);

	public List<UserImageDTO> getUploadList();

	
	public UserImageDTO getUploadUser(int seq);

	public void uploadUpdate(UserImageDTO userImageDTO2);

	public String getDeleteFileName(int seq);

	public void uploadDelete(int seq);

	public String getImageFileName(int seq);

	public void uploadUpdateSUB(UserImageDTO userImageDTO);

	public void uploadDeleteAll(List<Integer> list);
	
}
