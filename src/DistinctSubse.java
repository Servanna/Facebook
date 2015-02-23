
public class DistinctSubse {
	public static int numDistinct(String S, String T) {
		int m = T.length();
        int n = S.length();
        if(m == 0 || n == 0 || m > n){return 0;}
        int[][] dp = new int[m][n];
        if(S.charAt(0) == T.charAt(0)){
            dp[0][0] = 1;
        }
        for(int i = 1; i < m; i++){
            dp[i][0] = 0;
        }
        for(int j = 1; j < n; j++){
            if(S.charAt(j) == T.charAt(0)){
                dp[0][j] = dp[0][j-1]+1;
            }else{
                dp[0][j] = dp[0][j-1];
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = i; j < n; j++){
            	//System.out.println(i+ " " + j);
                if(S.charAt(j)!= T.charAt(i)){
                    dp[i][j] = dp[i][j-1];
                }else{
                	
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }
                //System.out.println(dp[i][j]);
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
            	System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        
        return dp[m-1][n-1];
    }
	public static void main(String[] args){
		String S = "aabb";
		String T = "ab";
		numDistinct(S, T);
		//System.out.print();
	}
}
