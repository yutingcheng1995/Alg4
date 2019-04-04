package offer;

import java.util.ArrayList;

public class SolutionPath {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        if(root == null){
            return res;
        }
        target = target - root.val;
        path.add(root.val);
        if(target == 0 && root.left == null && root.right == null){
             res.add(new ArrayList<>(path));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        path.remove(path.size()-1);
        return this.res;
    }
}
