package homework;

import java.util.Scanner;

public class SungJukUpdate implements SungJuk{

    Scanner sc = new Scanner(System.in);



    @Override
    public void execute() {

        System.out.println();

        System.out.print("수정할 이름 입력 : ");
        String name = sc.next();

    } // execute

} // end class
