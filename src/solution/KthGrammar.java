package solution;

import org.junit.Assert;
import org.junit.Test;

/**
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 *
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 */
public class KthGrammar {


    public int kthGrammar(int N, int K) {

        if(N == 2){
            return K - 1;
        }else {
            int i = 1;
            do{
                i <<= 1;
            }while (2 * i < K);
            int i1 = kthGrammar(N - 1, (K + 1) / 2);
            if(i1 == 0){
                return K % 2 ^ 1;
            }else{
                return K % 2;
            }
        }
    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(kthGrammar(4,9),1);
        Assert.assertEquals(kthGrammar(4,1),0);
        Assert.assertEquals(kthGrammar(4,3),1);
    }

}
