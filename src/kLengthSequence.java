
import java.util.ArrayList;
import java.util.List;


public class kLengthSequence {
	public static List<Integer> findKSequence(int[] num, int k){
		List<Integer> res = new ArrayList<Integer>();
		int[] n = new int[10];
		for(int i = 0; i < num.length; i++){
			n[num[i]] += 1;
		}
		int i = 9;
		while(k > n[i]){
			k -= n[i]; 
			i--;
		}
		for(int j = 0; j < num.length; j++){
			if(num[j]>i){
				res.add(num[j]);
			}else if(num[j] == i){
				res.add(num[j]);
				k--;
				if(k == 0){break;}
			}
		}
		return res;
	}
	public static void main(String[] args){
		int[] num = {9,8,9,7,6,1,5,8,7,9,5,3,1,7,4,6};
		int k = 10;
		System.out.print(findKSequence(num, k));
	}
}
