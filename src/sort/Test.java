package sort;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
        for (int i = integers.size() - 1; i >= 0; i--) {
            Integer integer =  integers.get(i);
            System.out.println(integer);

        }
    }
}
