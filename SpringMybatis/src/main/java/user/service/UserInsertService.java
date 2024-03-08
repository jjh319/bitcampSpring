package user.service;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.bean.UserDTO;
import user.dao.UserDAO;

import java.util.Scanner;

//@Setter
@Service
public class UserInsertService implements UserService{

    @Autowired
    private UserDTO userDTO;
    @Autowired
    private UserDAO userDAO;

    @Override
    public void execute() {
        System.out.println();
        Scanner scan = new Scanner(System.in);

        System.out.println("이름 입력 : ");
        String name = scan.next();
        System.out.println("아이디 입력 : ");
        String id = scan.next();
        System.out.println("비밀번호 입력 : ");
        String pwd = scan.next();

        userDTO.setName(name);
        userDTO.setId(id);
        userDTO.setPwd(pwd);

        userDAO.write(userDTO);

        System.out.println(name + " 님의 정보가 저장되었습니다.");
    } // execute

} // end class
