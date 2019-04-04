package cn.algm.cheng.sort;

/**
 * 选择排序：
 * 首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置；
 * 再次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置；
 * 循环
 */
public class Selection {
     public static void sort(Comparable[] arr){
         for(int i = 0; i < arr.length-1; i++){
             int min = i;
             for(int j = i+1; j < arr.length; j++){
                 if(Template.less(arr[j],arr[i]) < 0){
                     min = j;
                 }
             }
             Template.swap(arr,min,i);
         }
     }
}
