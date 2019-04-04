package javatest;
import java.io.File;

/**
 * File:文件或目录路径名的抽象表示；
 * 构造方法：
 *      File(String pathname):文件整体路径
 *      File(String parent,String child):目录和子文件路径
 *      File(File parent,String child)
 * 创建功能：
 *      createNewFile():创建文件
 *      mkdir():创建文件夹,若存在，则返回false
 *      mkdirs():创建多层文件夹；
 * 删除功能：
 *      delete():删除文件或空文件夹，删除不走回收站；
 * 重命名功能：
 *      renameTo(File dest):路径名相同，重命名；路径名不同，改名并剪切
 * 判断功能：
 *      isDirectory();
 *      isFile();
 *      exists();
 *      canRead();
 *      canWritten();
 *      isHidden();
 * 基本获取功能：
 *      getAbsolutePath();
 *      getPath();
 *      getName();
 *      length();字节数
 *      lastModified():毫秒值
 *      String[] list():名称数组
 *      File[] listFiles():文件对象数组
 * 例子：
 *  1.判断某个目录下是否包含后缀为.jpg的文件；
 *   - 基本方法：全部获取
 *   - 文件过滤器：list(FileFileter filter);
 *  2.输出某目录下所有文件的绝对路径
 *  3.递归删除带目录的路径
 */
public class FileIO {
    public static void printAllFilePath(File srcFolder){
        File[] files = srcFolder.listFiles();
        for(File file:files){
            if(file.isFile()&&file.getName().endsWith(".txt")){
                System.out.println(file.getAbsoluteFile());
            }
            else if(!file.isFile()){
                printAllFilePath(file);
            }
        }
    }
    public static void deleteAllFile(File srcFolder){
        File[] files = srcFolder.listFiles();
        //删除文件夹下所有文件
        for(File file:files){
            if(file.isFile()){
                System.out.println("File Deletion:"+"---"+file.delete());
            }
            else{
                deleteAllFile(file);
            }
        }
        //删除文件夹本身
        srcFolder.delete();
    }
    public static void main(String[] args)throws Exception{
     // deleteAllFile(new File("f:\\File1"));
    }
}
