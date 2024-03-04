package sample02;





public interface MessageBean {

    public default void sayHello(String name) {
        System.out.println("안녕하세요 " + name);

    } // sayHello

} // end class
