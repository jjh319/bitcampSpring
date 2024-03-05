package sample05_ANNO;

import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

@Log4j2
public class SungJukImpl implements SungJuk {

    private String name;
    private int kor;
    private int eng;
    private int math;
    private int tot;
    private double avg;

    Scanner sc = new Scanner(System.in);

    public SungJukImpl() {

        log.info("이름 입력 : " );
        name = sc.next();

        log.info("국어 입력 : " );
        kor = sc.nextInt();

        log.info("영어 입력 : " );
        eng = sc.nextInt();

        log.info("수학 입력 : " );
        math = sc.nextInt();


    } // Constructor

    @Override
    public void calc() {
        tot = kor + math + eng;
        avg = tot / 3.0;
    } // calc

    @Override
    public void display() {
        System.out.printf("이름 : %s, 국어 : %d, 영어 : %d, 수학 : %d, 총점 : %d, 평균 : %.2f %n",
               name, kor, eng, math, tot,  avg);
    } // display

} // end class
