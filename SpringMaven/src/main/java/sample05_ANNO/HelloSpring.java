package sample05_ANNO;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("root-context.xml");
        SungJuk sungJuk = (SungJuk) applicationContext.getBean("sungJukImpl");

        sungJuk.calc();
        sungJuk.display();

    } // main

} // end class
