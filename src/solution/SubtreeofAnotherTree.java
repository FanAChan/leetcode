package solution;

import base.TreeNode;
import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/13 22:04
 **/
public class SubtreeofAnotherTree {

	public boolean isSubtree(TreeNode s, TreeNode t) {

		if(s == null && t == null) {
			return true;
		}else if(s == null || t == null){
			return false;
		}
		if (s.val == t.val && isEqual(s,t)) {
			return true;
		} else {
			return isSubtree(s.left, t) || isSubtree(s.right, t);
		}
	}

	public boolean isEqual(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}else if(s != null && t != null && s.val == t.val){
			return isEqual(s.left,t.left) && isEqual(s.right,t.right);
		}
		return false;
	}

	@Test
	public void test() {

	}
}
