import java.util.HashMap;

/**
 * Created by qpan on 9/2/2017.
 */
public class LongestSubstring {

    public int lengthofLongestSubstring(String s){
        int n = s.length();
        if(n == 0)
            return 0;

        String[][] m = new String[n][n];

        for(int i = 0; i< n; i++){
            m[i][i] = s.substring(i, i + 1);
        }

        for (int l = 1; l< n; l++){
            for(int i = 0; i< n - l; i++){
                int j = i + l;

                String left = m[i][j - 1];
                String right = m[i +1][j];

                if(left.length() == l && right.length() == l){
                    String left_first = left.substring(0, 1);
                    String right_last = right.substring(right.length() - 1);
                    if(left_first.equals(right_last)){
                        m[i][j] = left;
                    }else {
                        m[i][j] = left + right_last;
                    }
                }else {
                    if(left.length() > right.length()){
                        m[i][j] = left;
                    }else {
                        m[i][j] = right;
                    }
                }
            }
        }
        return m[0][n - 1].length();
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }


    public static void main(String[] args) throws Exception
    {
        LongestSubstring longestSubstring = new LongestSubstring();

        String s = "abcabcbb";
        int length = longestSubstring.lengthOfLongestSubstring(s);
        System.out.println(length);
    }
}
