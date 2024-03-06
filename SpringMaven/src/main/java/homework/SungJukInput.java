package homework;


import lombok.Setter;

import java.util.List;
import java.util.Scanner;

public class SungJukInput implements SungJuk{

    @Setter
    private SungJukDTO2 sungJukDTO2;

    @Setter
    private List<SungJukDTO2> list;

    @Override
    public void execute() {

        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.print("이름을 입력하세요 : ");
        String name = sc.next();

        System.out.print("국어 점수를 입력하세요 : ");
        int kor = sc.nextInt();

        System.out.print("영어 점수를 입력하세요 : ");
        int eng = sc.nextInt();

        System.out.print("수학 점수를 입력하세요 : ");
        int math = sc.nextInt();

        int tot = kor + eng + math;
        double avg = tot / 3.0;

        sungJukDTO2.setName(name);
        sungJukDTO2.setKor(kor);
        sungJukDTO2.setEng(eng);
        sungJukDTO2.setMath(math);
        sungJukDTO2.setTot(tot);
        sungJukDTO2.setAvg(avg);

        list.add(sungJukDTO2);

        System.out.println(name + "님의 데이터를 등록 완료하였습니다.");

    } // execute

} // end class
