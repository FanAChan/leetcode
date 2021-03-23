package solution;

import javafx.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (null == image || image.length == 0) {
            return image;
        }
        if (null == image[0] || image[0].length == 0) {
            return image;
        }

        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return image;
        }

        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        image[sr][sc] = newColor;
        floodFill(image, sr + 1, sc, newColor,oldColor);
        floodFill(image, sr - 1, sc, newColor,oldColor);
        floodFill(image, sr, sc + 1, newColor,oldColor);
        floodFill(image, sr, sc - 1, newColor,oldColor);

        return image;
    }

    public void floodFill(int[][] image, int sr, int sc, int newColor,int oldColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return;
        }
        if(image[sr][sc] != oldColor){
            return;
        }
        image[sr][sc] = newColor;
        floodFill(image, sr + 1, sc, newColor,oldColor);
        floodFill(image, sr - 1, sc, newColor,oldColor);
        floodFill(image, sr, sc + 1, newColor,oldColor);
        floodFill(image, sr, sc - 1, newColor,oldColor);

    }

    @Test
    public void test() throws Exception {


        int[][] a = floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);
        for (int[] ints : a) {

        System.out.println(Arrays.toString(ints));
        }
    }
}
