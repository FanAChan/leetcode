package solution;

/**
 * @author Achan
 * @date 2018/5/1 18:54
 *
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * <p>
 * Follow up:
 * <p>
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 **/
public class CountingBits {

	public int[] countBits(int num) {
		if(num < 0){
			return null;
		}
		if(num == 0){
			return new int[]{0};
		}
		int[] results = new int[num+1];
		results[0]=0;
		results[1]=1;
		int t = 1;
		for(int i = 2;i<=num;i++){
			if(i == (t<<1)){
				t=t<<1;
				results[i]=1;
			}else{
				results[i] = results[i-t]+1;
			}
		}
		for (int result : results) {
			System.out.println(result);
		}
		return results;
	}

}
