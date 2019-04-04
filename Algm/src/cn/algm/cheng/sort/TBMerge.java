package cn.algm.cheng.sort;

/**
 * 递归实现归并
 */
public class TBMerge {
    public static void sort(Comparable[] arr, Comparable[] aux){
        sort(arr,aux,0,arr.length-1);

    }
    public static void sort(Comparable[] arr, Comparable[] aux, int lo, int hi){
        if(lo >= hi){
            return;
        }
        int mid = lo + (hi-lo)/2;
        sort(arr,aux,lo,mid);
        sort(arr,aux,mid+1,hi);
        Merge.merge(arr,aux,lo,mid,hi);
    }
}
