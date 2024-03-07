package user.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import user.service.UserService;

import java.util.Scanner;

public class HelloSpring {

    public void menu(ApplicationContext applicationContext) {
        Scanner sc = new Scanner(System.in);
        int num;

        UserService userService;

        while (true) {
            System.out.println("**********************");
            System.out.println("1. 입력");
            System.out.println("2. 출력");
            System.out.println("3. 수정");
            System.out.println("4. 삭제");
            System.out.println("5. 종료");

            System.out.print("번호 입력 : ");
            num = sc.nextInt();

            if(num == 5) {
                break;
            } // if

            if(num == 1) userService = (UserService) applicationContext.getBean("userInsertService");



        } // while

    } // menu

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("root.context.xml");
        HelloSpring helloSpring = (HelloSpring) applicationContext.getBean("helloSpring");

        helloSpring.menu(applicationContext);
        System.out.println("프로그램을 종료합니다.");

    } // main

} // end class
