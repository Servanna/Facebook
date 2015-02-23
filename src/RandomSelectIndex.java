import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/*
 *input: int[] array = {0,3,2,5,1,5,4,5}  
 *output: random(3,5,7)
 */
public class RandomSelectIndex {
	public static int randomMax(int[] num){
		if(num.length==0){return 0;}
		int max = num[0];
		for(int i = 1; i < num.length; i++){
			max = Math.max(num[i], max);
		}
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 0; i < num.length; i++){
			if(num[i] == max){
				res.add(i);
			}
		}
		Random rn = new Random();
		int r = rn.nextInt(res.size());
		return res.get(r);
	}
	public static void main(String[] args){
		int[] num = {0,3,2,10,5,1,5,4,5,6};
		System.out.print(randomMax(num));
	}
}
