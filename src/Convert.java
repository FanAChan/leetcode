import java.util.ArrayList;

public class Convert {


    public String convert(String s, int numRows) {

        if(null == s || "" == s || 1 == numRows) return s;

        int length = s.length();

        numRows = Math.min(numRows, length);

        boolean goDown = false;

        ArrayList<StringBuilder> list = new ArrayList<>(numRows);

        for(int i = 0;i<numRows;i++){
            list.add(new StringBuilder());
        }

        char[] chars = s.toCharArray();


        int curRow = 0;
        for (char c : chars) {
            list.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows - 1) goDown = !goDown;
            curRow += goDown?1:-1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            result.append(stringBuilder);
        }
        return result.toString();
    }
}
