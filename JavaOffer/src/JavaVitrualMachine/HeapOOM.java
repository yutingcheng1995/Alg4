package JavaVitrualMachine;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args:-Xms20m -Xmx20m -XX:+HeaoDumpOnOutOfMemoryError
 * 解决堆内存溢出问题需要分析堆转储快照：判断内存中的对象是否必要存在？
 * 即判断是否是内存泄露？
 *     - 是，进一步查看GC为什么不能回收这块内存。
 *     - 不是，查看当前内存是否能被扩展。
 *
 */

/**
 * 内存泄露和内存溢出：
 * 内存溢出：程序在申请内存时没有足够的内存空间供其使用；
 * 内存泄露:指程序在申请内存后，无法释放已申请的内存空间，一次内存泄露危害可以忽略，但内存泄露堆积后果很严重，无论多少内存,迟早会被占光
 * 多次内存泄露会导致内存溢出；（无用对象持续占有内存或者其占有内存得不到释放）
 * 内存泄露：一次性、偶发性、常发性、隐式；前三种类型与发生内存泄露的代码被执行次数有关；
 */
class OOMObject{

}
public class HeapOOM {
    public static void main(String args[]) {
        List<OOMObject> list = new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
