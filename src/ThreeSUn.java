import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




public class ThreeSUn {
	 public static List<List<Integer>> threeSum(int[] num) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
	        for(int i = 0; i < num.length; i++){
	        	ArrayList<Integer> list;
	        	if(map.containsKey(num[i])){
	        		list = map.get(num[i]);
	        	}else{
	        		list = new ArrayList<Integer>();
	        	}
	        	list.add(i);
	        	map.put(num[i], list);
	        }
	        for(int i = 0; i < num.length; i++){
	        	for(int j = i+1; j < num.length; j++){
	        		int target = 0 - num[i] - num[j];
	        			if(map.containsKey(target)){
	        				ArrayList<Integer> index = map.get(target);
	        				ArrayList<Integer> triple = new ArrayList<Integer>();
	        				triple.add(i); triple.add(j);
	        				for(int k : index){
	        					if(k > j ){
	        						triple.add(k);
	        						res.add(new ArrayList<Integer>(triple));
	        						triple.remove(triple.size()-1);
	        					}
	        				}
	        			}
	        	}
	        }
	        return res;
	    }
	 public static void main(String[] args){
		 int[] num = {-1, 0, 1, 2, -1, -4};
		 System.out.print(threeSum(num));
	 }
}
