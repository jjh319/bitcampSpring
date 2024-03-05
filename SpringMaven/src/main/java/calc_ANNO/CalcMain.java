package calc_ANNO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("root-context.xml");
        Calc calc;

        calc = (Calc) applicationContext.getBean("calcAdd");
        calc.calculate();

        calc = applicationContext.getBean("calcMul", Calc.class);
        calc.calculate();

    } // main

} // end class
