package solution;

import com.sun.org.apache.regexp.internal.RE;

public class Exist {

    public boolean exist(char[][] board, String word) {


        if(null == board || null == word || "".equals(word)){
            return false;
        }
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }

        int[][] visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(exist(board,word,visited,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean exist(char[][] board, String word,int[][] visited,int i,int j,int index) {
        if(index == word.length()){
            return true;
        }
        if(i < 0 || i >= board.length){
            return false;
        }
        if(j < 0 || j >= board[0].length){
            return false;
        }
        if(word.charAt(index) == board[i][j] && visited[i][j] == 0){
            visited[i][j] = 1;
            if(exist(board,word,visited,i + 1,j,index + 1) || exist(board,word,visited,i - 1,j,index + 1) || exist(board,word,visited,i,j + 1,index + 1) || exist(board,word,visited,i,j - 1,index + 1)){
                return true;
            }
            visited[i][j] = 0;
            return false;
        }
        return false;
    }
}
