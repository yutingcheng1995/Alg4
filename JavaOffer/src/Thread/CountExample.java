package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;




public class CountExample {
    private static int threadTotal = 200;
    private static int clientTotal = 5000;

    private static long count = 0;


    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);

        for(int i = 0; i < clientTotal; i++){
            exec.execute(()->{
                try{
                semaphore.acquire();
                add();
                semaphore.release();
                 }catch(Exception e){
                    //.error("Exception:"+e);

                }
            });

        }
        exec.shutdown();

    }

    private static void add(){
        count++;
    }
}
