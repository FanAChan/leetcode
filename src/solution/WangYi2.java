package solution;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Achan
 * @date 2018/8/11 15:50
 **/
public class WangYi2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		/**
		 * 每堆苹果前的数量
		 */
		int[] maxInEachIndex = new int[n];
		TreeMap<Integer, Integer> indexMap = new TreeMap<>();
		for(int i = 0;i<n;i++){
			int num = sc.nextInt();
			if(i != 0){
				maxInEachIndex[i] = maxInEachIndex[i-1] + num;
			}else{
				maxInEachIndex[i] = num;
			}
			indexMap.put(maxInEachIndex[i],i + 1);

		}
		int m = sc.nextInt();
		int[] asks = new int[m];
		for(int i = 0;i<m;i++){
			asks[i] = sc.nextInt();
		}
		int[] results = new int[m];
		for (int i = 0; i <m; i++) {
			Map.Entry<Integer, Integer> ceilingEntry = indexMap.ceilingEntry(asks[i]);
			results[i] = ceilingEntry.getValue();
		}
		for (int i = 0; i < results.length; i++) {
			System.out.println(results[i]);
		}


	}
}
