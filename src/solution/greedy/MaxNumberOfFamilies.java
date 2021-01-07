package solution.greedy;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class MaxNumberOfFamilies {


    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            Set<Integer> set = map.getOrDefault(reservedSeat[0], new HashSet<>());
            set.add(reservedSeat[1]);
            map.put(reservedSeat[0], set);
        }

        int num = n << 1;

        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            Set<Integer> set = entry.getValue();

            int valid = 2;
            for (int i = 2; i <= 5; i++) {
                if (set.contains(i)) {
                    valid--;
                    break;
                }
            }
            for (int i = 6; i <= 9; i++) {
                if (set.contains(i)) {
                    valid--;
                    break;
                }
            }
            if (valid == 0) {
                valid++;
                for (int i = 3; i <= 6; i++) {
                    if (set.contains(i)) {
                        valid--;
                        break;
                    }
                }
            }
            num -= 2 - valid;
        }
        return num;
    }


    public int maxNumberOfFamilies2(int n, int[][] reservedSeats) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int mid = 0b00111100;
        int left = 0b00001111;
        int right = 0b11110000;
        for (int[] reservedSeat : reservedSeats) {
            if (reservedSeat[1] == 1 || reservedSeat[1] == 10) {
                continue;
            }
            Integer temp = map.getOrDefault(reservedSeat[0], 0);
            temp += 1 << (reservedSeat[1] - 2);
            map.put(reservedSeat[0], temp);
        }

        int num = n << 1;

        for (Integer temp : map.values()) {

            int valid = 0;
            if ((temp & left) != 0) {
                valid++;
            }
            if ((temp & right) != 0) {
                valid++;
            }
            if (valid == 2 && (temp & mid) == 0) {
                valid--;
            }
            num -= valid;
        }
        return num;
    }

    @Test
    public void test() throws Exception {


        int[][] arr =
                {{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}};
        int[][] arr2 =
                {{4, 3}, {1, 4}, {4, 6}, {1, 7}};
        Assert.assertEquals(4, maxNumberOfFamilies2(3, arr));
    }
}
