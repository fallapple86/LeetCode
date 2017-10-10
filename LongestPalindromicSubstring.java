/**
 * Created by qpan on 9/4/2017.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int max_left = 0;
        int max_right = 0;
        char[] ch = s.toCharArray();
        for(int i = 0; i< s.length() - 1; i++){
            int left;
            int right;
            int max;
            if(ch[i] == ch[i + 1]){
                left = i - 1;
                right = i + 2;
                max = 2;
            }else{
                left = i - 1;
                right = i + 1;
                max = 1;
            }
            while(left >= 0 && right < s.length() && ch[left] == ch[right]) {
                max += 2;
                left -= 1;
                right += 1;
            }

            if((max_right - max_left + 1) < max){
                max_right = right - 1;
                max_left = left + 1;
            }
        }

        return s.substring(max_left, max_right + 1);
    }

    public static void main(String[] args) throws Exception
    {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

        String s = "bbabcdbb";

        String palindromic = longestPalindromicSubstring.longestPalindrome(s);
        System.out.println(palindromic);
    }
}
