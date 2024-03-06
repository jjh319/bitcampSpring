package homework;

import lombok.Setter;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SungJukDelete implements SungJuk{

    Scanner sc = new Scanner(System.in);

    @Setter
    private List<SungJukDTO2> list;

    @Override
    public void execute() {

        System.out.print("삭제할 이름 입력 : ");
        String name = sc.next();

        System.out.println();

        int sw = 0;
        Iterator<SungJukDTO2> it = list.iterator();
        while(it.hasNext()) { // 항목이 있으면 true, 없으면 false

            // it가 가리키는 항목을 꺼내서 저장한 후, it는 다음 항목으로 이동
            SungJukDTO2 sungJukDTO2 = it.next();

            if(sungJukDTO2.getName().equals(name)) {
                sw = 1;

                it.remove(); // 아까 보관했던 데이터를 삭제

                System.out.println("삭제 완료했습니다.");
                break;
            } // if

        } // for

        if(sw == 0) {
            System.out.println("찾고 있는 이름이 없습니다.");
        } // if

    } // execute

} // end class
