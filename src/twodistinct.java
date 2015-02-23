import java.util.HashMap;


public class twodistinct {
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = s.length();
        if(len <= 2){return len;}
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int l = 0;
        int r = 0;
        int max = 0;
        int count = 0;
        for(; r < s.length(); r++){
            char t = s.charAt(r);
            //System.out.print(t);
            if(map.containsKey(t)){map.put(t, map.get(t)+1); continue;}
            if(!map.containsKey(t)){
                 if(count < 2){
                     map.put(t, 1);
                     count++;
                     //System.out.println(count);
                     continue;
                 }
                 
                 max = Math.max(max, r - l);
                 //System.out.println(max);
                 while(l < r){
                         char left = s.charAt(l);
                         if(map.get(left) > 1){
                             map.put(left, map.get(left)-1);
                         }else{
                            map.remove(left);
                            count--;
                         }
                         if(count < 2){break;}
                        l++;
                  }
                 l++;
                 r--;
                 //System.out.println(l);
               }
             
        }
        max = Math.max(max, len-l);
        return max;
    }
	public static void main(String[] args){
		String s = "abcabcabc";
		System.out.print(lengthOfLongestSubstringTwoDistinct(s));
	}
}
