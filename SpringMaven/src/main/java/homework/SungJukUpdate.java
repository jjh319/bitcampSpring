package homework;

import lombok.Setter;

import java.util.List;
import java.util.Scanner;

public class SungJukUpdate implements SungJuk{

    Scanner sc = new Scanner(System.in);

    @Setter
    private List<SungJukDTO2> list;

    @Override
    public void execute() {

        System.out.println();

        System.out.print("수정할 이름 입력 : ");
        String name = sc.next();

        int sw = 0;

        for(SungJukDTO2 sungJukDTO2 : list) {

            if(sungJukDTO2.getName().equals(name)) {
                sw = 1;

                System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
                System.out.println(sungJukDTO2);

                System.out.println();

                System.out.print("국어 점수를 입력하세요 : ");
                int kor = sc.nextInt();

                System.out.print("영어 점수를 입력하세요 : ");
                int eng = sc.nextInt();

                System.out.print("수학 점수를 입력하세요 : ");
                int math = sc.nextInt();

                int tot = kor + eng + math;
                double avg = tot / 3.0;

                sungJukDTO2.setName(sungJukDTO2.getName());
                sungJukDTO2.setKor(kor);
                sungJukDTO2.setEng(eng);
                sungJukDTO2.setMath(math);
                sungJukDTO2.setTot(tot);
                sungJukDTO2.setAvg(avg);

                list.add(sungJukDTO2);
                System.out.println(name + "님의 데이터를 수정하였습니다.");

                break;
            } // if

        } // for

        if(sw == 0) {
            System.out.println("찾고자 하는 이름이 없습니다.");
        }

    } // execute

} // end class
