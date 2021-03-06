import java.util.HashMap;



public class TaskSchedule {
	public static int schedule(String s){
		if(s.length() == 0){return 0;}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int pre = 0;
		int cur = 0;
		for(int i = 0 ; i < s.length(); i++){
			char c = s.charAt(i);
			if(!map.containsKey(c)){
				cur = pre+1;
			}else{
				cur = Math.max(pre+1, map.get(c)+3);
			}
			map.put(c, cur);
			pre = cur;
		}
		
		return cur;
	}
	public static void main(String[] args){
		String s = "ABCDAABA";
		System.out.print(schedule(s));
	}
}
