package user.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;


    @Override
    public String checkId(String id) {

        UserDTO userDTO = userDAO.checkId(id);

        if(userDTO == null) {
            return "non_exist";
        } else {
            return "exist";
        } // if-else


    } // checkId

} // end class
