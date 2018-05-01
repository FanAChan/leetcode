import java.util.ArrayList;
import java.util.List;

/**
 * @author Achan
 * @date 2018/4/5 13:24
 **/
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            }
            list.add("" + n);
        }
        return list;
    }

    public List<String> fizzBuzz2(int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 1, fizz = 0, buzz = 0; i <= n; i++) {
            fizz++;
            buzz++;
            if (fizz == 3 && buzz == 5) {
                list.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            } else if (fizz == 3) {
                list.add("Fizz");
                fizz = 0;
            } else if (buzz == 5) {
                list.add("Buzz");
                buzz = 0;
            } else {
                list.add("" + n);
            }
        }
        return list;
    }
}
