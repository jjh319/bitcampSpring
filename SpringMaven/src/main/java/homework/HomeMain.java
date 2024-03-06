package homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class HomeMain {

    public void menu(ApplicationContext applicationContext) {
        System.out.println();
        Scanner sc = new Scanner(System.in);
        SungJuk sungJuk = null;

        while(true) {
            System.out.println("****************************");
            System.out.println("1. 입력");
            System.out.println("2. 출력");
            System.out.println("3. 수정");
            System.out.println("4. 삭제");
            System.out.println("5. 종료");
            System.out.println("****************************");

            System.out.print("번호 : ");
            int num = sc.nextInt();

            if(num == 5) break;

            if(num == 1) {
                sungJuk = (SungJuk) applicationContext.getBean("sungJukInput");
            } else if(num == 2) {
                sungJuk = (SungJuk) applicationContext.getBean("sungJukOutput");
            } else if(num == 3) {
                sungJuk = (SungJuk) applicationContext.getBean("sungJukUpdate");
            } else if(num == 4) {
                sungJuk = (SungJuk) applicationContext.getBean("sungJukDelete");
            } // if-else if

            sungJuk.execute();

        } // while

    } // menu

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("root-context.xml");
        HomeMain homeMain = (HomeMain) applicationContext.getBean("homeMain");

        homeMain.menu(applicationContext);
        System.out.println("프로그램을 종료합니다.");

    } // main

} // end class
