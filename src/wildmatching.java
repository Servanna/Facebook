
public class wildmatching {
	public static boolean isMatch(String s, String p) {
        int ii = -1, jj = -1, i = 0, j = 0;
        while (i < s.length()) {
            if (j < p.length() && p.charAt(j) == '*') {
                while (j < p.length() && p.charAt(j) == '*') ++j;
                if (j == p.length()) return true;
                ii = i;
                jj = j;
                System.out.println(ii + " " + jj);
            }
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                ++i; ++j;
            } else {
                if (ii == -1) return false;
                ++ii;
                i = ii;
                j = jj;
                //System.out.println(i + " " + j);
            }
        }
        while (j < p.length() && p.charAt(j) == '*') ++j;
        //System.out.println(ii + " " + jj);
        return i == s.length() && j == p.length();
    }
	public static void main(String[] args){
		String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
		String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
		System.out.print(isMatch(s,p));

	}
}
