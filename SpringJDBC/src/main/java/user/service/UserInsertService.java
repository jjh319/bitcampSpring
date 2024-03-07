package user.service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

import java.util.Scanner;

public class UserInsertService implements UserService{

    @Setter
    private UserDTO userDTO;

    @Setter
    private UserDAO userDAO;

    @Override
    public void execute() {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.print("이름 입력 : ");
        String name = sc.next();

        System.out.print("아이디 입력 : ");
        String id = sc.next();

        System.out.print("비밀번호 입력 : ");
        String pwd = sc.next();

        userDTO.setName(name);
        userDTO.setId(id);
        userDTO.setPwd(pwd);

    } // execute

} // execute
