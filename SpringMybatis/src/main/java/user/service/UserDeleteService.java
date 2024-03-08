package user.service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

import java.util.List;
import java.util.Scanner;

@Setter
public class UserDeleteService implements UserService{

    private UserDAO userDAO;

    @Override
    public void execute() {

        Scanner sc = new Scanner(System.in);

        System.out.print("삭제할 아이디 입력 : ");
        String id = sc.next();

        List<UserDTO> list = userDAO.getUserList();

        int sw = 0;
        for(UserDTO userDTO : list) {

            if(userDTO.getId().equals(id)) {

                sw = 1;
                userDAO.deleteUser(userDTO);
                list.remove(userDTO);

                System.out.println("삭제를 완료했습니다.");
                break;

            } // if

        } // enhanced for

        if(sw == 0) {
            System.out.println("아이디가 존재하지 않습니다.");
        } // if

    } // execute

} // end class
