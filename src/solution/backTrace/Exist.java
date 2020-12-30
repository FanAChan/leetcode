package solution.backTrace;

import org.junit.Assert;
import org.junit.Test;

public class Exist {

    public boolean exist(char[][] board, String word) {

        boolean[][] used = new boolean[board.length][board[0].length];
        int[][] moves = {{-1,0},{1,0},{0,1},{0,-1}};
        for (int i = 0; i < board.length; i++) {
            char[] b = board[i];
            for (int j = 0; j < b.length; j++) {
                if(backTrace(board,word,used,0,moves,i ,j)){
                    return true;
                }
            }
        }
        return false;

    }

    boolean backTrace(char[][] board, String word,boolean[][] used,int charIndex,int[][] moves,int i,int j){
        if(i >= 0 && i < board.length && j >= 0 && j< board[0].length && board[i][j] == word.charAt(charIndex) && !used[i][j]){
            used[i][j] = true;
        }else{
            return false;
        }

        if(charIndex == word.length() - 1){
            return true;
        }

        for (int[] move : moves) {
            i += move[0];
            j += move[1];
            if(backTrace(board,word,used,charIndex + 1,moves,i,j)){
                return true;
            }
            i -= move[0];
            j -= move[1];
        }
        used[i][j] = false;
        return false;
    }

    boolean backTrace2(char[][] board, String word,boolean[][] used,int charIndex,int[][] moves,int i,int j) {
        if(board[i][j] != word.charAt(charIndex)){
            return false;
        }else if(charIndex == word.length() - 1){
            return true;
        }
        used[i][j] = true;

        for (int[] move : moves) {
            i += move[0];
            j += move[1];
            if(i >= 0 && i < board.length && j >= 0 && j< board[0].length && !used[i][j]){
                if(backTrace(board,word,used,charIndex + 1,moves,i,j)){
                    return true;
                }
            }
            i -= move[0];
            j -= move[1];
        }
        used[i][j] = false;
        return false;
    }


    @Test
    public void test() throws Exception {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
        Assert.assertTrue(exist(board, "ABCCED"));
        Assert.assertTrue(exist(board, "SEE"));
        Assert.assertFalse(exist(board, "ABCB"));
    }
}
