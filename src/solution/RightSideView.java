package solution;

import base.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }


        Queue<TreeNode> levelNodeQueue = new LinkedList<>();

        levelNodeQueue.offer(root);

        while (!levelNodeQueue.isEmpty()) {
            int size = levelNodeQueue.size();
            Integer thisLevelRightSideViewNum = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = levelNodeQueue.poll();
                thisLevelRightSideViewNum = node.val;
                if (null != node.left) {
                    levelNodeQueue.offer(node.left);
                }

                if (null != node.right) {
                    levelNodeQueue.offer(node.right);
                }

            }
            result.add(thisLevelRightSideViewNum);
        }
        return result;
    }




    //--------------- dfs----------------
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView2(TreeNode root) {
        dfs(root, 0); // 从根节点开始访问，根节点深度是0
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        if (depth == res.size()) {   // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }

}
