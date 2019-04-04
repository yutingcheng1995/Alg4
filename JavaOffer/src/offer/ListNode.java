package offer;

public class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int[] arr){
        this.val = arr[0];
        ListNode cur = this;
        for(int i = 1; i < arr.length; i++){
            cur.next = new ListNode(arr[i]);;
            cur = cur.next;
        }
    }
}
