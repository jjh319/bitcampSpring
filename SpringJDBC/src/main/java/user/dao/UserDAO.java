package user.dao;

import user.bean.UserDTO;

import java.util.List;

public interface UserDAO {
    public void write(UserDTO userDTO);


    public List<UserDTO> getUserList();
}
