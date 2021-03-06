/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class RecoverTree99 {

    /**
     * 迭代访问：用栈,再用一个指针模拟访问过程
     */
    public void recoverTree(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        TreeNode p = root;
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);

        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(pre.val>p.val){
                if(firstNode==null){
                    firstNode = pre;
                }
                secondNode = p;
            }

            pre = p;
            p = p.right;
        }

        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }

    /**
     * 递归
     */
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    TreeNode firstNode = null;
    TreeNode secondNode = null;

    public void recoverTree2(TreeNode root){
        in_order(root);
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val= tmp;
    }

    private void in_order(TreeNode node){
        if(node==null){
            return;
        }
        in_order(node.left);

        if(pre.val>node.val){
            if(firstNode==null){
                firstNode = pre;
            }
            secondNode = node;
        }
        pre = node;
        in_order(node.right);
    }
}