package JavaVitrualMachine;

/**
 * VM Args:-Xss128k
 * 堆栈泄露异常：线程请求的堆栈深度超过允许范围；
 * 内存泄露：虚拟机在扩展时无法申请更多的空间；
 * 在单线程下，无论是栈帧太大，还是虚拟机栈容量太少，都会抛出StackOverFlowError异常；
 * 通过不断建立内存，可以产生内存溢出异常；（减少其他区域的占用内存或者减少线程的栈容量）
 */
public class JVMStackSOF {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }
    public static void main(String[] args){
               JVMStackSOF sof = new JVMStackSOF();
               try{
                   sof.stackLeak();
               }catch(Throwable e){
                   System.out.println("sof.stackLength:"+sof.stackLength);
                   throw e;
               }
    }
}
