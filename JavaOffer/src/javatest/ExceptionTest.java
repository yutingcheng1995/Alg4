package javatest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 1.finally:异常处理的一部分；
 *  其控制的语句一定会执行；
 *  在finally之前JVM退出；
 *  用于释放资源，在IO流和数据库中常见;
 * 2.catch中有return，finally依然可以执行，且在return前置执行
 * 准确的说是在中间，
 *   try{
 *       System.out.println(a/0);
 *       a = 20;
 *   }catch(ArithmeticException e){
 *       a = 30;
 *       return a;//return 30-----a = 40-------return 30
 *   }finally{
 *       a = 40;
 *   }
 *
 *  2.自定义异常，有以下两种方式：
 *    继承Exception，需要处理try...caych或者throws MyException
 *    继承RuntimeException,不需要专门处理，throw new MyException();
 *  3.子类重写父类方法时,使用抛出异常的方法处理异常：
 *     - 子类抛出异常的覆盖范围小于等于父类；
 *     - 子类不能抛出父类没有的异常；
 *     - 父类没有抛出异常，则子类有异常通过try...catch....处理异常
 *
 */
class MyException extends RuntimeException{
    //要想在抛出异常时汇报错误信息，需要定义构造方法
    public MyException(){
        super();
    }
    public MyException(String s){
        super(s);
    }

}

class Fu{
    public void show()throws Exception{

    }
}
class zi extends Fu{
  public void show()throws Exception{

  }
}
public class ExceptionTest {
    public static void main(String[] args){
        String str = "2014-11-20";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-xx-dd");
        try{
         Date d = sdf.parse(str);
        }catch(ParseException e){
            e.printStackTrace();
        }
    }


}
