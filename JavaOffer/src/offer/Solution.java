package offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;



public class Solution {

    /**
     * 归并两个有序链表
     * - 设置虚拟节点；
     * - 一般情况，两个均不为空
     * - 有一个为空
     * - 返回
     * @return
     */
    public static ListNode Merge(ListNode list1, ListNode list2) {
       ListNode dummyHead = new ListNode(0);
       ListNode cur = dummyHead;
       ListNode p = list1;
        ListNode q = list2;
       while(p !=null && q!=null){
           if(p.val <= q.val){
               cur.next = new ListNode(p.val);
               p = p.next;
           }
           else{
               cur.next = new ListNode(q.val);
               q = q.next;
           }
           cur = cur.next;
       }
       if(p == null){
           cur.next = q;
       }
       if(q == null){
           cur.next = p;
       }
       return dummyHead.next;
    }

    /**
     * 判断B是否是A的子结构；
     *
     */
    public static boolean isSubTree(TreeNode A, TreeNode B){
        boolean res = false;

        if(B.val == A.val){
            res = isEqual(A.left,B.left)&&isEqual(A.right,B.right);

        }
        if(!res){
            res = isSubTree(A.left,B);
        }
        if(!res){
            res = isSubTree(A.right,B);
        }
        return res;
    }
    private static boolean isEqual(TreeNode A, TreeNode B){
        if(A==null && B==null){
            return true;
        }
        if(A==null){
            return false;
        }
        if(B==null){
            return false;
        }
        if(A.val != B.val){
            return false;
        }
        else{
            return isEqual(A.left,B.left)&&isEqual(A.right,B.right);
        }
    }

    /**
     *输出倒数第k个节点:
     * - 常规思路
     * - 简洁思路
     *   - 两个指针p,q
     *   - 1 2 3 ... k
     *     q         p
     *     当p在终点时，q指向倒数第k个元素
     *
     * @return
     */
    public static ListNode FindKthToTail(ListNode head,int k) {
        ListNode cur = head;
        int count = 0;
        while(cur!=null){
            count++;
            cur = cur.next;
        }
        int cnt = 1;
        cur = head;
        while(cur != null){
            if(cnt == count+1-k){
                return cur;
            }
            cnt++;
            cur = cur.next;
        }
        return null;
    }
    public static ListNode FindKthToTail1(ListNode head,int k) {
        if(head==null||k<=0){
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        //int cnt = 1;
        for(int cnt = 1; cnt < k; cnt++){
            if(p == null){
                return null;
            }
            p = p.next;
        }
        if(p == null){
            return null;
        }
        while(p.next != null){
            p = p.next;
            q = q.next;
        }
        return q;
    }

    /**
     * 反转链表
     *
     * @param
     */
    public static ListNode ReverseList(ListNode head) {
       if(head == null || head.next == null){
           return head;
       }
       ListNode pre = head;
       ListNode cur = head.next;

       while(cur != null){
           ListNode temp = cur.next;
           cur.next = pre;
           pre = cur;
           cur = temp;
       }
        head.next = null;//很重要的一步，使得逆序链表的结尾节点指向空
       return pre;
    }
    /**
     * 一个数base的整数次方expo
     *
     * @param
     */
    /**
     * 调整数组位置使奇数位于偶数之前
     * - i记录首个偶数位置，j记录偶数之后的首个奇数位置；
     * - 记录j处的值，将i和j-1之间的值全部后移，保证奇数和偶数的顺序不变
     * - 之后将j处的值放入i处
     *
     * @param
     */
    public static void reOrderArray(int [] arr){
        int i = 0;
        int j = 0;
        while(i < arr.length){
            if(arr[i]%2 == 1){
                i++;
            }

            else{
                j = i + 1;
                while(j < arr.length){
                    if(arr[j]%2 == 0){
                        j++;
                    }
                    else{
                        break;
                    }
                }
                if(j >= arr.length){
                    break;
                }
                int temp = arr[j];
                while(j > i){
                    arr[j] = arr[j-1];
                    j--;
                }
                arr[i] = temp;
            }
        }
    }

    /**
     * 二叉树的镜像
     *
     * @param
     */
    public static void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        switchChild(root);
    }
    private static TreeNode switchChild(TreeNode root){
        if(root.left == null && root.right == null){
            return root;
        }
        root.right = switchChild(root.left);
        root.left = switchChild(root.right);
        return root;
    }

    /**
     * 栈的压入序列和弹出序列判断：
     * 给定一个压入序列
     * 给定一个弹出序列
     * - 循环
     *    - 如果当前压入序列中的元素和弹出序列不一致
     *      压栈
     *    - 如果一样
     *      - 弹出序列index+1
     *        {循环判断该值是否是栈顶元素
     *        是的话出栈、弹出序列index+1}
     *
     */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length != popA.length){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0; i<pushA.length; i++){
            stack.push(pushA[i]);
           while(!stack.isEmpty()) {
               if (stack.peek() == popA[j]) {
                   stack.pop();
                   j++;
               } else {
                   break;
               }
           }
        }
       return stack.isEmpty();
    }

    /**
     * 求出一个数组可以组成的最小的数，例如{3,32,321}-321323
     * 1.先转化为String数组；
     * 2.设置一定的规则对String数组排序；
     *   ？此处涉及到对两种比较方法的使用；
     *   - 实现Comparable接口，重写接口中的compareTo方法；
     *   - 定义一个匿名Comparator对象重写compareTo方法并将其作为方法的参数传入；
     * 3.合并
     * @param numbers
     * @return
     */
    public static String PrintMinNumber(int [] numbers) {
        if(numbers.length == 0){
            return "";
        }
         ArrayList<String> res = new ArrayList<>();
         for(int i = 0; i < numbers.length; i++){
             res.add(String.valueOf(numbers[i]));
         }
         res.sort(new Comparator<String>() {
             @Override
             public int compare(String o1, String o2) {
                 String r1 = o1+o2;
                 String r2 = o2+o1;
                 return r1.compareTo(r2);
             }
         });
         StringBuilder res1 = new StringBuilder();
         for(int i = 0; i < numbers.length; i++ ){
             res1.append(res.get(i));
         }
         return res1.toString();
    }

    /**
     * 判断一个数是不是丑数，只包含质因子2,3,5;任意一个整数可以写成多个质因子的指数次方的乘积；
     * N = a^b*c^d...(a,c均为质数,b,d均为非负整数)
     * 假设一个数组，按序存储index个丑数，如何将其排序呢？
     * 从头到尾计算丑数;
     * 假设已有丑数数组；那么丑数数组中每个值分别x2,x3,x5可得到一个新的丑数，为了有序，我们每次只插入一个；
     * @param index
     * @return
     */
    public static int GetUglyNumber_Solution(int index) {
        if(index <=0){
            return 0;
        }
        int res[] = new int[index];
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        res[0] = 1;
        for(int i = 1; i < index; i++){
            int temp = getMin(res[index2]*2,res[index3]*3,res[index5]*5);
            res[i] = temp;
            if(temp == res[index2]*2){
                index2++;
            }
            if(temp == res[index3]*3){
                index3++;
            }
            if(temp == res[index5]*5){
                index5++;
            }
        }
        return res[index-1];

    }
    private static int getMin(int i, int j, int k){
        int temp = i < j ? i :j;
        return temp > k? k:temp;
    }
    public static boolean isUglyNumber(int N){
        while(N%2 == 0){
            N=N/2;
        }
        while(N%3 == 0){
            N=N/3;
        }
        while(N%5 == 0){
            N=N/5;
        }
        return N==1;
    }

    /**
     * 寻找数组中只出现一次的数：
     * 在一个数组中，其他的数均出现偶数次，有两个数只出现一次，找出这两个数；
     * 将这些数全部异或，则最终答案相当于是只出现一次的数异或；
     * 然后根据这个异或的值，将这组数分为两组，其中保证这两个数分别出现在这两组；
     * @param array
     * @param num1
     * @param num2
     */
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int num = 0;
        for(int i = 0; i < array.length; i++){
            num = num ^array[i];
        }
        int temp = num;
        int index = 0;
        //判断temp从右起
        while((temp & 1) != 1){
            temp = (temp>>1);
            index++;
        }
        int com = 1<<index;
        int res1 = 0;
        int res2 = 0;
        for(int i =0 ; i< array.length;i++){
            if((array[i]&com)==0){
             res1 = res1^array[i];

            }
            else{
               res2 = res2^array[i];
            }
        }
        num1[0] = res1;
        num2[0] = res2;
    }

    /**
     * 约瑟夫环的问题：每次删掉第m-1个数，求最后一个删掉的数；
     * 0 1 2 3 ... k-1 k k+1 ... n-1
     * k = (m-1)%n
     * n个数中最后删除的数 = n-1个数中最后删除的数 = ...
     * 寻找这些序列之间的递推关系；
     * - 首次删除第m-1个数：
     *   0 1 2 3 ...m-1 m ... n-1
     *
     *
     * @param n
     * @param m
     * @return
     */

   public static void main(String[] args){
        int[] array=new int[]{2,2,3,4,5,5,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
       FindNumsAppearOnce(array,num1,num2);
       System.out.println(num1[0]);
       System.out.println(num2[0]);
    }
}
