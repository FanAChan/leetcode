package codewar;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BitCounting {
    public static int countBits(int n){
        // Show me the code!
        int result = 0;
        while (n > 0){
            result += n & 1;
            n >>= 1;
        }
        return result;
    }

     @Test
    public void testGame() {
        assertEquals(5, BitCounting.countBits(1234));
        assertEquals(1, BitCounting.countBits(4));
        assertEquals(3, BitCounting.countBits(7));
        assertEquals(2, BitCounting.countBits(9));
        assertEquals(2, BitCounting.countBits(10));
    }
}
