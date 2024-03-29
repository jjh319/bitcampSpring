package sungJuk_ANNO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component // 빈 등록
public class SungJukDTO {

    private String name;
    private int kor;
    private int eng;
    private int math;
    private int tot;

    public String getName() {
        return name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(@Value("97") int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(@Value("100") int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(@Value("66") int math) {
        this.math = math;
    }

    public int getTot() {
        return tot;
    }

    public void setTot(int tot) {
        this.tot = tot;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public void setName(@Value("홍길동") String name) {
        this.name = name;
    }

    private double avg;

    @Override
    public String toString() {
        return name + "\t" + kor + "\t" +
                eng + "\t" + math + "\t" +
                tot + "\t" + String.format("%.2f", avg);
    } // toString

} // end class
