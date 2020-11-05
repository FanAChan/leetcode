package solution;


public class NumTrees {


    public int numTrees(int n) {
        if(n == 0) return 0;
        int[] array = new int[n+1];
        array[0] = 1;
        array[1] = 1;
        //长度为i的以j为跟的序列构造的树的数量
        for(int i = 2;i <= n;i++){
            for(int j = 1;j <= i;j++) {
                //左树的数量 * 右树的数量
                array[i] += array[j - 1] * array[i - j];
            }
        }
        return array[n];
    }

    public static void main(String[] args) {

        NumTrees numTrees = new NumTrees();
        System.out.println(numTrees.numTrees(19));
    }
}
