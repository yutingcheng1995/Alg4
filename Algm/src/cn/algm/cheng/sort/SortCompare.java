package cn.algm.cheng.sort;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Shell;

/**
 * 边界情况：
 *      数组可能已经是有序的，或是逆序的;
 *      数组的所有主键相同，数组的主键只有两种值;
 *      大小为0 或是1 的数组;
 */
//import .Random;
public class SortCompare {
    public static double time(String alg,Double[] a){
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        /*if (alg.equals("Merge")) Merge.sort(a);
        if (alg.equals("Quick")) Quick.sort(a);
        if (alg.equals("Heap")) Heap.sort(a);*/
        Template.show(a);
        return timer.elapsedTime();
    }
    public static double timeRandomInput(String alg,int N,int T){
        double total = 0.0;
        Double[] arr = new Double[N];
        for(int i = 0; i < T; i++){
            for(int j = 0; j < N; j++){
                arr[j] = StdRandom.uniform();
            }
            total = total + time(alg,arr);
        }
        return total;
    }

    public static void main(String[] args) {
        String[] str = new String[]{"Insertion","Selection","Shell"};
        System.out.println(str[0] +":"+timeRandomInput(str[0],10,10));
        System.out.println(str[1] +":"+timeRandomInput(str[1],10,10));
        System.out.println(str[2] +":"+timeRandomInput(str[2],10,10));
    }
}
