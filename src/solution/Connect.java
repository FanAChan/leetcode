package solution;

import base.Node;
import base.TreeNode;

public class Connect {

    public Node connect(Node root) {
        if(null == root){
            return root;
        }
        root.next = null;
        connect(root.left,root.right);
        return root;
    }

    public void connect(Node left,Node right) {
        if(null != left){
            left.next = right;
            connect(left.left,left.right);
            connect(left.right,right.left);
            connect(right.left,right.right);
        }
    }

    private Node last;

    private Node nextLevelStart;


    public Node connectV2(Node root) {
        if(null == root){
            return root;
        }
       Node start = root;

        while (null != start){
            last = null;
            nextLevelStart = null;
            while (null != start){
                if(null != start.left){
                    this.handlerNode(start.left);
                }
                if(null != start.right){
                    this.handlerNode(start.right);
                }
                start = start.next;
            }
            start = nextLevelStart;
        }
        return root;
    }

    private void handlerNode(Node node){
        if(null != last){
            last.next = node;
        }
        if(null == nextLevelStart){
            nextLevelStart = node;
        }
        last = node;
    }


}
