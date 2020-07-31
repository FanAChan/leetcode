package codewar;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Persist {
    public static int persistence(long n) {
        // your code
        int i = 0;
        while (n >= 10){
            i++;
            int temp = 1;
            while (n > 0 && temp != 0) {
                temp *= n % 10;
                n /= 10;
            }
            n = temp;
        }
        return i;
    }
    @Test
    public void BasicTests() {
        System.out.println("****** Basic Tests ******");
        assertEquals(3, Persist.persistence(39));
        assertEquals(0, Persist.persistence(4));
        assertEquals(2, Persist.persistence(25));
        assertEquals(4, Persist.persistence(999));
    }

}
