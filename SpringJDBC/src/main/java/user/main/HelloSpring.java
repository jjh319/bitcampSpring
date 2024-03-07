package user.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import user.service.UserService;

import java.util.Scanner;

public class HelloSpring {

    public void menu(ApplicationContext applicationContext){
        Scanner scan = new Scanner(System.in);
        int num;
        UserService userService = null;
        while(true){

            System.out.println();
            System.out.println("1. 입력");
            System.out.println("2. 출력");
            System.out.println("3. 수정");
            System.out.println("4. 삭제");
            System.out.println("5. 끝");
            System.out.println("번호 입력 : ");
            num = scan.nextInt();

            if(num==1) {
                userService = (UserService) applicationContext.getBean("userInsertService");
            }else if(num==2) {
                userService = (UserService) applicationContext.getBean("userSelectService");
            }
            else if(num==3) {
                userService = (UserService) applicationContext.getBean("userUpdateService");
            }else if(num==4) {
                userService = (UserService) applicationContext.getBean("userDeleteService");
            } // if-else if

            if(num==5) break;

            userService.execute();

        } // while

    } // menu

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("root-context.xml");
        HelloSpring helloSpring = applicationContext.getBean("helloSpring",HelloSpring.class);
        helloSpring.menu(applicationContext);

        System.out.println("\n프로그램 종료합니다");
    } // main

} // end class
