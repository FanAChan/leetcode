package solution;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {


    public List<String> generateParenthesis(int n) {


        ArrayList<String> result = new ArrayList<>();
        if (n == 0)
            return result;

        List<StringBuilder> builders = generateParenthesis(new StringBuilder(), n, n);
        for (StringBuilder builder : builders) {
            result.add(builder.toString());
        }
        return result;
    }

    public List<StringBuilder> generateParenthesis(StringBuilder start, int leftNum, int rightNum) {
        ArrayList<StringBuilder> temp = new ArrayList<>();

        if(leftNum == rightNum && leftNum == 0){
            temp.add(start);
            return temp;
        }
        if (start.length() == 0 && leftNum > 0)   {
            start.append("(");
            temp.addAll(generateParenthesis(start, leftNum - 1, rightNum));
        }else {
            if(leftNum > 0){
                StringBuilder tempSB = new StringBuilder(start);
                tempSB.append("(");
                temp.addAll(generateParenthesis(tempSB, leftNum - 1, rightNum));
            }
            if(leftNum < rightNum && rightNum > 0){
                StringBuilder tempSB = new StringBuilder(start);
                tempSB.append(")");
                temp.addAll(generateParenthesis(tempSB, leftNum, rightNum - 1));
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        generateParenthesis.generateParenthesis(3);
    }
}
