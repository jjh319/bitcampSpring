package Chapter02_ANNO;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring2 {

    public static void main(String[] args) {
        ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("root-context.xml");

        MessageBean messageBean =applicationContext2.getBean(MessageBean.class);

        messageBean.sayHello();
        messageBean.sayHello("딸기", 10000);
        messageBean.sayHello("망고", 9000, 2);

    } // main

} // end class
