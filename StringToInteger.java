/**
 * Created by qpan on 9/4/2017.
 */
public class StringToInteger {
    public int myAtoi(String str) {
        char[] ch = str.trim().toCharArray();

        boolean is_Negative = false;
        int start = 0;

        if(ch[0] == '-' || ch[0] == '+'){
            if(ch[0] == '-'){
                is_Negative = true;
            }
            start = 1;
        }

        int result = 0;

        for(int i = start; i< ch.length; i++){
            int value = ch[i] - '0';
            if(value > 9 || value < 0){
                throw new java.lang.Error("Not a valid number.");
            }else {
                int new_result = result * 10 + value;

                if((new_result - value)/10 != result){
                    throw new java.lang.RuntimeException("Overflow!");
                }

                result = new_result;
            }
        }

        if(is_Negative){
            result = -result;
        }
        return result;
    }

    public int myAtoi1(String str) {
        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if(str.length() == 0) return 0;

        //2. Remove Spaces
        while(str.charAt(index) == ' ' && index < str.length())
            index ++;

        //3. Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        //4. Convert number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }

    public static void main(String[] args) throws Exception
    {
        String s = "-01234*56789+";

        StringToInteger stringToInteger = new StringToInteger();
        int result = stringToInteger.myAtoi1(s);

        System.out.println(result);

    }
}
