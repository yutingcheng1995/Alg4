package javatest;

/**
 * 线程安全：
 *   - 线程的调度顺序不影响任何结果；
 * 同步:java中的同步指人为的控制和调度，保证多线程访问成为线程安全；
 *
 * 线程状态:
 * - 创建、就绪、运行、阻塞、结束
 *
 */
class MyThread extends Thread{
    private int count = 5;
    public MyThread(String name){
        super();
        this.setName(name);
    }
    public void run(){
        super.run();
        count--;
        System.out.println(this.currentThread().getName()+":"+count);

    }
}

class MyThread2 extends Thread{
    private int count = 7;
    public void run(){
        super.run();
        count--;
        System.out.println(this.currentThread().getName()+":"+count);
    }
}

class MyThread3 extends Thread{
    private int count = 7;
    synchronized public void run(){
        super.run();
        count--;
        System.out.println(this.currentThread().getName()+":"+count);
    }
}

class MyRunnable implements Runnable{
    public void run(){
        System.out.println("Running");
    }
}
public class MulThread {
    public static void main(String[] args){
         dataSharedInThreadSecurity();
    }
    public static void dataSharedInThreadSecurity(){
        MyThread3 my = new MyThread3();
        Thread a = new Thread(my,"A");
        Thread b = new Thread(my,"B");
        Thread c = new Thread(my,"C");
        Thread d = new Thread(my,"D");
        Thread e = new Thread(my,"E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
    //线程不安全
    public static void dataSharedInThread(){
        MyThread2 my = new MyThread2();
        Thread a = new Thread(my,"A");
        Thread b = new Thread(my,"B");
        Thread c = new Thread(my,"C");
        Thread d = new Thread(my,"D");
        Thread e = new Thread(my,"E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
    public static void dataNoSharedInThreads(){
      MyThread m1 = new MyThread("m1");
      MyThread m2 = new MyThread("m2");
      MyThread m3 = new MyThread("m3");
      m1.start();
      m2.start();
      m3.start();
    }
}
