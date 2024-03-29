package Chapter02_XML;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("root-context.xml");

        MessageBean messageBean = (MessageBean) applicationContext.getBean("messageBeanImpl", MessageBean.class);

        messageBean.sayHello();
        messageBean.sayHello("딸기", 10000);
        messageBean.sayHello("망고", 9000, 2);

    } // main

} // end class
