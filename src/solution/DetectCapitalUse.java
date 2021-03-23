package solution;

public class DetectCapitalUse {

    public boolean detectCapitalUse(String word) {

        char[] charArray = word.toCharArray();
        int len = charArray.length;

        int count = 0;
        for (int i = 1; i < charArray.length; i++) {
            char c = charArray[i];

            if('A'<=c && c<= 'Z'){
                count++;
            }
        }
        if(count == 0 && ('A'<=word.charAt(0) && word.charAt(0)<= 'Z' && count +1 == len)){
            return true;
        }
        return false;

    }
}
