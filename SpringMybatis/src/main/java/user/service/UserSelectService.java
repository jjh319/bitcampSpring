package user.service;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.bean.UserDTO;
import user.dao.UserDAO;

import java.util.List;

//@Setter
@Service
public class UserSelectService implements UserService{

    @Autowired
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
