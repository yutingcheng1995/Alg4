package javatest;

public class LoginB extends Thread{
    public void run(){
        LoginServelet.doPost("b","bb");
    }
}
