package solution.greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;

        while (i < s.length && j < g.length) {
            if (s[i] >= g[j]) {
                j++;
            }
            i++;
        }
        return j;
    }

    @Test
    public void test() throws Exception {


        Assert.assertEquals(2,findContentChildren(new int[]{1,5,3},new int[]{1,2,3,4}));
        Assert.assertEquals(2,findContentChildren(new int[]{1,2},new int[]{1,2,3}));
    }
}
