package sample01;

import lombok.Setter;

public class MessageBeanImpl implements MessageBean{

    @Setter
    private String str;


    @Override
    public void showPrintBefore() {
        System.out.println("showPrintBefore 메세지 : " + str);
    } // showPrintBefore

    @Override
    public void viewPrintBefore() {
        System.out.println("viewPrintBefore 메세지 : " + str);
    } // viewPrintBefore

    @Override
    public void display() {
        System.out.println("================================");
    } // display

    @Override
    public void showPrintAfter() {
        System.out.println("showPrintAfter 메세지 : " + str);
    } // showPrintAfter

    @Override
    public void viewPrintAfter() {
        System.out.println("viewPrintAfter 메세지 : " + str);
    } // viewPrintAfter

    @Override
    public void showPrint() {
        System.out.println("showPrint 메시지 : " + str);
    } // showPrint

    @Override
    public void viewPrint() {
        System.out.println("viewPrint 메시지 : " + str);

    } // viewPrint

} // end class
