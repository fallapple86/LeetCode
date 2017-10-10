/**
 * Created by qpan on 9/4/2017.
 *
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999
 */
public class ReverseInteger {
    public int reverse(int x) {
        char[] ch = Integer.toString(Math.abs(x)).toCharArray();

        StringBuilder sb = new StringBuilder();
        for(int i=ch.length; i> 0; i--){
            sb.append(ch[i - 1]);
        }

        int result;
        try{
            result = Integer.parseInt(sb.toString());

            result = x > 0? result: -result;

        }catch (Exception ex){
            result = 0;
        }

        return result;
    }

    //Solution from LeetCode
    public int reverse1(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }

    public static void main(String[] args) throws Exception
    {
        ReverseInteger reverseInteger = new ReverseInteger();

        int x = 100000000;
        int result = reverseInteger.reverse1(x);

        System.out.println(result);

    }
}
