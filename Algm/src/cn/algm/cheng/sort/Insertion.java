package cn.algm.cheng.sort;

/**
 * 插入排序：
 * 将每个元素插入到之前排好序的元素中;
 * arr[i]插入arr[i-1],...,arr[0]
 * 比较arr[i]和arr[j]
 */
public class Insertion {
    public static void sort(Comparable[] arr){
        for(int i = 1; i < arr.length; i++){
            for(int j = i; j > 0; j--){
               if(Template.less(arr[j],arr[j-1])<0){
                   Template.swap(arr,j,j-1);
               }
            }
        }
    }
}
