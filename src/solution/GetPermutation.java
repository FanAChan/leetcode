package solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class GetPermutation {

    public String getPermutation(int n, int k) {
        int[] count = new int[n];
        count[0] = 1;
        for (int i = 1; i < n; i++) {
            count[i] = count[i - 1] * i;
        }

        int[] visited = new int[n];
        Arrays.fill(visited,-1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1 ; i <= n; i++){
           int num = (k - 1) / count[n - i] + 1;
           for(int j = 0;j<n;j++){
               if(visited[j] == -1 && (--num) == 0){
                   stringBuilder.append(j + 1);
                   visited[j] = 1;
                   break;
               }
           }
           k = (k - 1) % count[n - i] + 1;
        }
        return stringBuilder.toString();
    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(getPermutation(3,1),"123");
    }

}
