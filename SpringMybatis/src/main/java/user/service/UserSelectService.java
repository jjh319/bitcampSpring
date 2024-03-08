package user.service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

import java.util.List;

@Setter
public class UserSelectService implements UserService{

    private UserDAO userDAO;

    @Override
    public void execute() {
        System.out.println();

        List<UserDTO> list = userDAO.getUserList();
        System.out.println("이름 아이디 비밀번호");
        for(UserDTO userDTO : list){
            System.out.println(userDTO);

        } // for

    } // execute

} // end class
