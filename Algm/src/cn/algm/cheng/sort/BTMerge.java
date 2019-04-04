package cn.algm.cheng.sort;

/**
 * 非递归实现归并
 */
public class BTMerge {
    public static void sort(Comparable[] arr,Comparable[] aux){
        for(int sz = 1; sz < arr.length; sz=sz+sz){
            for(int lo = 0; lo < arr.length-sz; lo = lo+sz+sz){
                Merge.merge(arr,aux,lo,lo+sz-1,Math.min(lo+sz+sz-1,arr.length));
            }
        }
    }
}
