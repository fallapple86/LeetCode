import java.util.HashMap;

/**
 * Created by qpan on 9/28/2017.
 */
public class IntToRoman {
    public String intToRoman(int num){
        HashMap map = new HashMap<Integer, String>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");

        int n = String.valueOf(num).length();
        int ind = 1;
        for(int i = 1; i< n; i++){
            ind *= 10;
        }

        StringBuilder result = new StringBuilder();
        while (ind >= 1){
            int digit = num / ind;
            if(digit == 9){
                result.append(map.get(ind));
                result.append(map.get(ind * 10));
            }else{
                if(digit >= 5){
                    result.append(map.get(5 * ind));
                    digit -= 5;
                }
                for(int d = 0; d < digit; d++){
                    result.append(map.get(ind));
                }
            }
            num -= num/ind * ind;
            ind /= 10;
        }
        return result.toString();
    }
    public static void main(String[] args) throws Exception
    {
        int input = 18;
        IntToRoman intToRoman = new IntToRoman();
        String result = intToRoman.intToRoman(input);
        System.out.print(result);
    }
}
