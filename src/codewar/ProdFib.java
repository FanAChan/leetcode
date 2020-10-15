package codewar;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ProdFib {


    public static long[] productFib(long prod) {
        // your code\
        long n = 0;
        long m = 1;
        long mutli = n * m;
        long[] result = null;
        while (true) {

            if (mutli == prod) {
               result = new long[]{n, m, 1};
               break;
            } else if (mutli > prod) {
                result = new long[]{n, m, 0};
                break;
            }else{
                long temp = n;
                n = m;
                m = temp + n;
                System.out.println(n + "," + m);
                mutli = n * m;
            }

        }
        return result;
    }

    @Test
    public void test1() {
        long[] r = new long[] {55, 89, 1};
        assertArrayEquals(r, ProdFib.productFib(4895));
    }
    @Test
    public void test2() {
        long[] r = new long[] {89, 144, 0};
        assertArrayEquals(r, ProdFib.productFib(5895));
    }


}
