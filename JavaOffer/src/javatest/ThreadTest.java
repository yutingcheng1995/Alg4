package javatest;

class MyThreadTest extends Thread{
    public MyThreadTest(){
      System.out.println("MyThread---Begin");

      System.out.println("MyThread---end");
    }
    public void run(){
        System.out.println("Run---Begin");
        /*System.out.println("Run-Thread Name:"+ Thread.currentThread().getName());
        System.out.println("Run-Thread isAlive:"+ Thread.currentThread().isAlive());
        System.out.println("this.getName()="+this.getName());
        System.out.println("this.isAlive()="+this.isAlive());*/
        System.out.println("Run---end");
    }
}
public class ThreadTest {
    public static void main(String[] args){
        MyThreadTest t1= new MyThreadTest();
       //tt.start();
      // Thread t1 = new Thread(tt);
        t1.start();
        t1.interrupt();
       System.out.println("ISAlive:"+t1.isAlive());
        System.out.println("ISAlive:"+t1.interrupted());
        System.out.println("ISAlive:"+Thread.currentThread().isAlive());
        System.out.println("ISAlive:"+Thread.currentThread().interrupted());
       System.out.println("ISAlive:"+t1.isAlive());

    }

}
