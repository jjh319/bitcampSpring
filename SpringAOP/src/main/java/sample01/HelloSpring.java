package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("acQuickStart.xml");
        MessageBean messageBean = applicationContext.getBean("messageBeanImpl", MessageBean.class);

        //Before
        messageBean.showPrintBefore();
        System.out.println();

        messageBean.viewPrintBefore();
        System.out.println();

        messageBean.display();
        System.out.println();

        //After
        messageBean.showPrintAfter();
        System.out.println();

        messageBean.viewPrintAfter();
        System.out.println();

        messageBean.display();

        // around
        messageBean.showPrint();
        System.out.println();

        messageBean.viewPrint();
        System.out.println();

        messageBean.display();

    } // main

} // end class
