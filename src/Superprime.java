import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Superprime {
	public static List<Integer> findSuper(int n){
		List<Integer> res = new ArrayList<Integer>();
		if(n < 3){return res;}
		List<Integer> prime = new ArrayList<Integer>();
		
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 2; i <= n; i++){
			if(!set.contains(i)){
				prime.add(i);
				if(prime.contains(prime.indexOf(i)+1)){
					res.add(i);
				}
				int j = 1;
				while(i*j <= n){
					set.add(i*j);
					j++;
				}
			}
		}
		System.out.println(prime);
		return res;
	}
	public static void main(String[] args){
		System.out.print(findSuper(20));
	}
}
