package calc_ANNO;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class CalcAdd implements Calc {


    private int x;
    private int y;

    public CalcAdd(@Value("25") int x , @Value("35") int y) {
        this.x = x;
        this.y = y;
    } // Constructor

    @Override
    public void calculate() {

        System.out.println(x + " + " + y + " = " + (x+y));

    } // calculate

} // end class
