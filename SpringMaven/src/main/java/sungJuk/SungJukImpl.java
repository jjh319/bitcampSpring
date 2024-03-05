package sungJuk;

import lombok.AllArgsConstructor;

import java.util.Scanner;


@AllArgsConstructor
public class SungJukImpl implements SungJuk{

    private SungJukDTO sungJukDTO;

    @Override
    public void calcTot() {
        sungJukDTO.setTot(sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath());
    } // calcTot

    @Override
    public void calcAvg() {
        sungJukDTO.setAvg(sungJukDTO.getTot() / 3.0);
    } // calcAvg

    @Override
    public void calcDisplay() {
        System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
        System.out.println(sungJukDTO);
    } // calcDisplay

    @Override
    public void modify() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("이름 입력 : ");
        String name = sc.next();

        System.out.print("국어 입력 : ");
        int kor = sc.nextInt();

        System.out.print("영어 입력 : ");
        int eng = sc.nextInt();

        System.out.print("수학 입력 : ");
        int math = sc.nextInt();

        sungJukDTO.setName(name);
        sungJukDTO.setKor(kor);
        sungJukDTO.setEng(eng);
        sungJukDTO.setMath(math);

    } // modify

} // end class
