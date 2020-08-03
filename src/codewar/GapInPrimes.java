package codewar;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class GapInPrimes {

    public static long[] gap(int g, long m, long n) {
        // your code
        while (m < n - g) {
            if (isPrime(m) && isPrime(m + g)) {
                if (havePrime(m, m + g)) {
                    m += g;
                } else {
                    long[] result = new long[2];
                    result[0] = m;
                    result[1] = m + g;
                    return result;
                }
            }
            m++;
        }
        return null;
    }

    private static boolean isPrime(long n) {
        int i = 2;
        long max = n / 2;
        while (i < max) {
            if ((n % i) == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static boolean havePrime(long m, long n) {
        while (m < n - 1) {
            m++;
            if (isPrime(m)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println("Fixed Tests");
        assertEquals("[101, 103]", Arrays.toString(GapInPrimes.gap(2,100,110)));
        assertEquals("[103, 107]", Arrays.toString(GapInPrimes.gap(4,100,110)));
        assertEquals(null, GapInPrimes.gap(6,100,110));
        assertEquals("[359, 367]", Arrays.toString(GapInPrimes.gap(8,300,400)));
        assertEquals("[337, 347]", Arrays.toString(GapInPrimes.gap(10,300,400)));
    }
}
