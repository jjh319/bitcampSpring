package sungJuk_ANNO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SungJukMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("root-context.xml");
        SungJuk sungJuk = (SungJuk) applicationContext.getBean("sungJukImpl");
        sungJuk.calcTot();
        sungJuk.calcAvg();
        sungJuk.calcDisplay();

        sungJuk.modify();
        sungJuk.calcTot();
        sungJuk.calcAvg();
        sungJuk.calcDisplay();

    } // main

} // end class
