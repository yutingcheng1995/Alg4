package cn.algm.cheng.sort;

/**
 * 希尔排序：
 *  1. 确定最大步长h
 *  2. 基于步长对数组进行插入排序；
 */
public class Shell {
    public static void sort(Comparable[] arr){
        int N = arr.length;
        //确定最大步长
        int h = 1;
        while(h < N/3){
            h = h*3+1;
        }
        //从步长最大开始，对每个步长排序，直到步长为1；
        while(h >= 1){
            for(int i = h; i < N; i= i + h){
                for(int j = i; j > 0; j=j-h){
                    if(Template.less(arr[j],arr[j-h])<0){
                        Template.swap(arr,j,j-h);
                    }
                }
            }
            h = h/3;
        }
    }
}
