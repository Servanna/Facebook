
public class OneEditDistance {
	public static boolean isOneEditDistance(String s, String t) {
        int S = s.length();
        int T = t.length();
        if(S < T){return isOneEditDistance(t,s);}
        if((S==0 && T == 0) || S-T > 1){return false;}
        int i = 0;
        while(i < T){
            if(t.charAt(i) != s.charAt(i)){
                break;
            }
            i++;
        }
        System.out.print(i);
        if(S == T){
            i++;
            while(i < T){
                if(t.charAt(i) != s.charAt(i)){
                    return false;
                }
                i++;
            }
            
        }else{
            while(i < T){
                if(t.charAt(i) != s.charAt(i+1)){
                    return false;
                }
                i++;
            }
        }
        return true;
    }
	public static void main(String[] args){
		System.out.print(isOneEditDistance("c", "c"));
	}
}
