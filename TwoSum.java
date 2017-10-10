import java.util.HashMap;

/**
 * Created by qpan on 8/24/2017.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap map = new HashMap();
        for(int i = 0; i<nums.length; i++){
            int value = nums[i];
            if(map.containsKey(value)){
                return new int[]{(int)map.get(value), i};
            }else{
                int remains =  target - nums[i];
                map.put(remains, i);
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception
    {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;

        TwoSum sum = new TwoSum();
        int[] result = sum.twoSum(nums, target);

        for(int i: result) {
            System.out.print(i);
        }
    }

}
