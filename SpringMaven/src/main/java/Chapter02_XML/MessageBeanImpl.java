package Chapter02_XML;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
public class MessageBeanImpl implements MessageBean{

    @NonNull
    private String fruit;

    @Setter
    private int cost;

    @Setter
    private int qty;



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
