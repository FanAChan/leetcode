package solution;

import org.junit.Test;

import java.util.*;

public class FindAndReplacePattern {


    public List<String> findAndReplacePattern(String[] words, String pattern) {


        ArrayList<String> result = new ArrayList<>();
        if(null == words || words.length == 0){
            return result;
        }

        int len = pattern.length();

        boolean valid = true;
        for (String word : words) {
            HashMap<Character, Character> fx = new HashMap<>();
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < len; i++) {
                Character character = fx.get(pattern.charAt(i));
                if(null == character && !set.contains(word.charAt(i))){
                    set.add(word.charAt(i));
                    fx.put(pattern.charAt(i), word.charAt(i));
                }else {
                    if(character == null || character != word.charAt(i)){
                        valid = false;
                        break;
                    }
                }
            }
            if(valid){
                result.add(word);
            }
            valid = true;
        }
        return result;
    }


    @Test
    public void test() throws Exception {

        System.out.println(findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"},"abb"));;
    }
}
