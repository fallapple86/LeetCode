/**
 * Created by qpan on 9/28/2017.
 */
public class MaxArea {
    public int maxArea(int[] height){
        if(height.length < 2){
            return 0;
        }
        int max = 0;
        for(int i = 0, j = height.length -1; i < j;){
            int v = (j - i) * Math.min(height[i], height[j]);
            if(v > max){max = v;}
            if(height[i] < height[j]){
                i ++;
            }
            else {
                j--;
            }
        }
        return max;
    }
    public static void main(String[] args) throws Exception
    {
        int[] nums = new int[]{2, 4, 5, 3, 2, 1};

        MaxArea maxArea = new MaxArea();
        int result = maxArea.maxArea(nums);
        System.out.print(result);
    }
}
