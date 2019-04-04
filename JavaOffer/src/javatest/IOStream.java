package javatest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IO流的用途:处理设备之间的数据传输；
 *      - 上传和下载文件
 * IO流的分类：
 *      输入流：从硬盘等设备读取数据；
 *      输出流：向硬盘等设备写数据；
 *
 *     数据类型：
 *        字节流:最小单位；字节输入流InputStream、字节输出流OutputStream,抽象类
 *        字符流：一个字符两个字节，为了方便操作文本数据；字符输入流Reader、字符输出流Writer
 *        使用条件：文本数据使用字符流，其他使用字节流；
 * 需求：往文本文件中输入一句话：“Hello,io”;
 *    - 创建字节输出流做了几件事情?
 *    - 为什么使用close()
 *    - 如何实现数据换行
 *    - 如何实现数据的追加写入
 */

/**
 * 字符流 = 字节流 + 编码表
 * 常见编码表：
 *  ASCII
 *  ISO-8859-1
 *  GB2312
 *  GBK
 *  GB18030
 *  UTF-8
 * 字符串中的编码问题：
 *   编码：String--byte[]
 *      OutputStreamWriter(OutputStream os)默认编码：GBK
 *      OutputStreamWriter(OutputStream os,String charsetName)
 *      InputStreamReader(InputStream os)默认编码：GBK
 *      InputStreamWriter(InputStream os,String charsetName)
 *   解码：byte[]--String
 */

/**
 * IO流
 *  - 字节流
 *      - 字节输入流
 *         InputStream
 *              int read():一次读取一个字节；
 *              int read(byte[] bys):一次读取一个字节数组；
 *              - FileInputStream
 *              - BufferedInputStream
 *      - 字节输出流
 *         OutputStream
 *                 int write(byte by):一次写一个字节；
 *  *              int write(byte[] bys,int index,int length):一次写一个字节数组的一部分；
 *  *              - FileOutputStream
 *  *              - BufferedOutputStream
 *  - 字符流
 *     - 字符输入流
 *        Reader
 *           int read():一次读取一个字符
 *           int read(char[] cha):一次读取一个字符数组；
 *           - InputStreamReader
 *             - FileReader
 *           - BufferedReader
 *             - String readLine():一次读取一个字符串
 *     - 字符输出流
 *         Writer
 *             void write(int ch)：一次写一个字符
 *             void write(byte[] bys,int index,int length)：写一个字节数组的一部分
 *             - OutputStreamWriter
 *                - FileWriter
 *             - BufferedWriter
 *                void newLine()：写一个换行符
 */
public class IOStream {
    public static void main(String[] args)throws IOException {
       // File file = new File("file.txt");
        //创建字节输出流对象：1.调用系统功能创建文件2.创建文件对象3.把对象指向文件
        /**
         * 关闭流对象
         * - 让流对象成为垃圾，这样就可以被GC；
         * - 让系统释放该文件的相关资源；
         */
    long start = System.currentTimeMillis();
    method1("F:\\Test\\file.txt","F:\\Test\\file3.txt");
    long end = System.currentTimeMillis();
    System.out.println("耗时："+(end - start)+"ms");

    }

    public static void method1(String name,String newName)throws IOException{
        FileInputStream fis = new FileInputStream(name);
        FileOutputStream fos = new FileOutputStream(newName);

        int by = 0;
        while((by = fis.read())!=-1){
            fos.write(by);
        }
        fos.close();
        fis.close();

       /*int len = 0;
       byte[] byt = new byte[1024];
       while((len = fis.read(byt))!=-1){
           fos.write(byt,0,len);
       }
        fos.close();
        fis.close();*/


    }
}
