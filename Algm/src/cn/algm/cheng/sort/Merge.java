package cn.algm.cheng.sort;

public class Merge {
    public static void merge(Comparable[] arr, Comparable[] aux, int lo, int mid,int hi){
        //为辅助数组赋值
        for(int i = lo; i <= hi; i++){
            aux[i] = arr[i];
        }
        int i = lo;
        int j = mid+1;
        //借助辅助数组归并两个有序子序列，并将正确顺序赋值给arr数组
        for(int k = lo; k < hi+1; k++){
            if(i > mid){
                //i中的数组已经全部走完
                arr[k] = aux[j];
                j++;
            }
            else if(j > hi){
                //j中的数组已经全部走完
                arr[k] = aux[i];
                i++;
            }
            else if(Template.less(aux[i],aux[j])<=0){
                //aux[i]<=aux[j]
                arr[k] = aux[i];
                i++;
            }
            else if(Template.less(aux[i],aux[j])>0){
                //aux[i]>aux[j]
                arr[k] = aux[j];
                j++;
            }
        }
    }
}
