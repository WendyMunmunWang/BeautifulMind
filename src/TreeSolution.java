/**
 * Created by wendywang on 2017-08-27.
 */
public class TreeSolution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        while (p != null & q != null){
            if (p.val == q.val) {
                p = p.left;
                q = q.left;
            }
        }
        return false;
    }
}
