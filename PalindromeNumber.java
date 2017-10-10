/**
 * Created by qpan on 9/4/2017.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0){return false;}

        int reverted = 0;
        while(x > reverted){
            reverted = reverted * 10 + x%10;
            if(x/10 == reverted || x == reverted){
                return true;
            }
            x = x/10;
        }
        return false;
    }

    public boolean isPalindrome1(int x) {
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber/10;
    }



        public static void main(String[] args) throws Exception
    {
        PalindromeNumber palindromeNumber = new PalindromeNumber();

        int x = 12321;
        String result = palindromeNumber.isPalindrome1(x)? "Yes": "No";
        System.out.println(result);
    }
}
