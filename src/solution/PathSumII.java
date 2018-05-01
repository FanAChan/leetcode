package solution;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Achan
 * @date 2018/4/7 13:39\
 * <p>
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * <p>
 * return
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 **/
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        List<Integer> current = new ArrayList<>();
        pathSum(root, sum, results, current);
        return results;
    }

    public void pathSum(TreeNode root, int sum, List<List<Integer>> results, List<Integer> current) {
        if (root == null) {
            return;
        }
        current.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            results.add(new ArrayList<>(current));
//        } else if(root.val > sum ) {
//            //donothing and remove the last ele
//        } else if(root.val < sum) {
            //ele maybe a negative integer
        } else if(root.val < sum) {
            pathSum(root.left, sum - root.val, results, current);
            pathSum(root.right, sum - root.val, results, current);
        }
        current.remove(current.size() - 1);
    }


}

