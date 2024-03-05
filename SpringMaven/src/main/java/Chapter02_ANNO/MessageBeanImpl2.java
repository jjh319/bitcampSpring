package Chapter02_ANNO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class MessageBeanImpl2 implements MessageBean {

    private String fruit;
    private int cost;
    private int qty;

    @Autowired
    public MessageBeanImpl2(@Value("사과") String fruit) {
        this.fruit = fruit;
    } // Constructor

    @Autowired
    public void setCost(@Value("5000") int cost) {
        this.cost = cost;
    } // setCost

    @Autowired
    public void setQty(@Value("3") int qty) {
        this.qty = qty;
    } // setCost

    @Override
    public void sayHello() {
        System.out.println(fruit + "\t" + cost + "\t" + qty);
    } // sayHello

    @Override
    public void sayHello(String fruit, int cost) {
        System.out.println(fruit + "\t" + cost + "\t" + qty);
    } // sayHello

    @Override
    public void sayHello(String fruit, int cost, int qty) {
        System.out.println(fruit + "\t" + cost + "\t" + qty);
    } // sayHello

} // end class
