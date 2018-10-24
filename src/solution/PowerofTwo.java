package solution;

/**
 * @author Achan
 * @date 2018/9/17 13:41
 **/
public class PowerofTwo {

	public boolean isPowerOfTwo(int n) {
		if(n <= 0){
			return false;
		}else{
			int result = 0;
			for (int i = 0; i < 32; i++) {
				if ((n & 1) == 1) {
					result++;
				}
				n >>= 1;
			}
			return result == 1;
		}
	}

}
