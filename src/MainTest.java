import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MainTest {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("2200.156");
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String format = decimalFormat.format(bigDecimal.doubleValue());
        System.out.println(format);
    }
}
