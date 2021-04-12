package solution;

import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Queue;

public class LongestPrefix {

    public String longestPrefix(String s) {


        int n = s.length();
        int i = n - 1;
        while (i > 0) {
            if (s.substring(0, i).equals(s.substring(n - i))) {
                return s.substring(0, i);
            }
            i--;
        }
        return "";

    }

}
