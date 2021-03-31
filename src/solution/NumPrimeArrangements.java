package solution;

import org.junit.Assert;
import org.junit.Test;

public class NumPrimeArrangements {


    public int numPrimeArrangements(int n) {
        int  i = 2;
        int count = 0;
        while (i <= n){
            if (isPrime(i)) {
                count++;
            }
            i++;
        }
        long result = 1;
        i = count;
        while (i > 0){
            result *= i;
            result %= 1000000007;
            i--;
        }

        i = n-count;
        while (i > 0){
            result *= i;
            result %= 1000000007;
            i--;
        }
        return (int)(result % 1000000007);

    }

    private boolean isPrime(int n){
        int i = 2;
        while (i <= n / 2){
            if(n % i == 0){
                return false;
            }
            i++;
        }
        return true;
    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(numPrimeArrangements(100),682289015);
    }
}
