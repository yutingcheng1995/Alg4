package offer;
/**
 * 判断是否是二叉平衡树？
 * 根据左右子树的深度差；
 * 有两种方法：
 * 自顶向下:基于求路径的递归方法，从上到下每一层节点判断其左右子树的深度差；
 * 自底向上:在每一次判断时，
 *      如果当前左子树不是二叉平衡树，则直接返回;
 *      如果当前右子树不是二叉平衡树，则直接返回;
 *      如果当前左右均是二叉平衡树，则判断当前节点;
 *
 * @return
 */
public class IsBalanced {
    boolean isBalance = true;
    public boolean IsBalanced_Solution(TreeNode root){
       getDepth(root);
       return isBalance;
   }
    public int getDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(Math.abs(left-right)>1){
            isBalance = false;
        }
        return 1 + Math.max(left,right);
    }
}
