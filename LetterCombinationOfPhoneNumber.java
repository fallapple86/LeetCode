import java.util.*;

/**
 * Created by qpan on 8/24/2017.
 *
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters is just like on the telephone buttons.
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 */
public class LetterCombinationOfPhoneNumber {
    public List<String> digitMapping(String digit){
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        int index = Integer.parseInt(digit);

        return Arrays.asList(mapping[index].split(""));
    }

    public List<String> matrixProduct(List<String> lst1, List<String> lst2){
        int lst1_length = lst1.size();
        int lst2_length = lst2.size();

        List<String> result = new ArrayList<>();
        for(int i = 0; i< lst1_length; i++){
            for(int j = 0; j< lst2_length; j++){
                result.add(lst1.get(i) + lst2.get(j));
            }
        }
        return result;
    }

    /**
     * Using recursive method to partition digits
     * */
    public List<String> letterCombinations(String digits) {
        if(digits.length() > 2){
            int partion = digits.length() / 2;
            String left = digits.substring(0, partion);
            String right = digits.substring(partion, digits.length());

            List<String> lst_left = letterCombinations(left);
            List<String> lst_right = letterCombinations(right);

            return matrixProduct(lst_left, lst_right);
        }else if(digits.length() == 2){
            List<String> lst_left = digitMapping(digits.substring(0, 1));
            List<String> lst_right = digitMapping(digits.substring(1, 2));
            return matrixProduct(lst_left, lst_right);
        }else {
            return digitMapping(digits);
        }
    }

    /**
     * Using Queue method
     */
//    public List<String> letterCombinations(String digits) {
//        LinkedList<String> ans = new LinkedList<String>();
//        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        ans.add("");
//        for (int i = 0; i < digits.length(); i++) {
//            int x = Character.getNumericValue(digits.charAt(i));
//            while (ans.peek().length() == i) {
//                String t = ans.remove();
//                for (char s : mapping[x].toCharArray())
//                    ans.add(t + s);
//            }
//        }
//        return ans;
//    }


    public static void main(String[] args) throws Exception
    {
        LetterCombinationOfPhoneNumber letter = new LetterCombinationOfPhoneNumber();
        List<String> output = letter.letterCombinations("054");
        System.out.println(output.size());
        for(String str : output){
            System.out.println(str);
        }
    }
}
