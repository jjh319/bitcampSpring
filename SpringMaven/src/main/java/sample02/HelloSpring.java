package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("root-context.xml");
//        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/resources/root-context.xml");

        MessageBean messageBean = (MessageBean) applicationContext.getBean("messageBean");
        messageBean.sayHello("Spring");

    } //main

} // end class
