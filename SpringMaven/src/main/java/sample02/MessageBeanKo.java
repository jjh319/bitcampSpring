package sample02;


import lombok.extern.log4j.Log4j2;

@Log4j2
public class MessageBeanKo implements MessageBean {


    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }

} // end class
