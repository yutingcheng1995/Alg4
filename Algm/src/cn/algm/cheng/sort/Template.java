package cn.algm.cheng.sort;

public class Template {
    public static int less(Comparable v,Comparable w){
        return v.compareTo(w);
    }
    public static void swap(Comparable[] arr,int i,int j){
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static void show(Comparable[] arr){
        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }

    public static boolean idSorted(Comparable[] arr, int flag) throws Exception{
        for(int i = 1; i < arr.length; i++){
            if(flag==0){
                if(less(arr[i-1],arr[i]) >0){
                    return false;
                }
            }
            else if(flag==1){
                if(less(arr[i-1],arr[i]) < 0){
                    return false;
                }
            }
            else{
                throw new Exception("flag is illegal! 0 or 1!");
            }
        }
        return true;
    }
}
