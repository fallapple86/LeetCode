import javax.print.attribute.standard.Media;

/**
 * Created by qpan on 9/3/2017.
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 *
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */

public class MedianOfTwoSortedArray {
    // Implementation of my rough thought
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int start_a = 0;
        int start_b = 0;
        int end_a = m - 1;
        int end_b = n - 1;

        while(true){
            int median_a = start_a +  (end_a - start_a + 1) /2;
            int median_b = start_b + ( (end_b - start_b + 1) %2 != 0? (end_b - start_b + 1) /2 :(end_b - start_b + 1) /2 - 1 > 0 ? (end_b - start_b + 1) /2 - 1 : 0 );

            if(((median_b - 1 >= 0 && nums1[median_a] > nums2[median_b - 1]) || median_b - 1 < 0) && ((median_b + 1 < n && nums1[median_a] < nums2[median_b + 1]) || median_b + 1 >= n)){
                if(((median_a - 1 >= 0 && nums2[median_b] > nums1[median_a - 1]) || median_a - 1 < 0) && ((median_a + 1 < n && nums2[median_b] < nums1[median_a + 1]) || median_a + 1 >= m)){
                    if((m + n) % 2 == 0){
                        return (nums1[median_a] + nums2[median_b]) * 1.0 / 2;
                    }else {
                        if(median_a + median_b < (m  - median_a - 1 + n -median_b - 1)){
                            return Math.max(nums1[median_a], nums2[median_b]);
                        }else {
                            return Math.min(nums1[median_a], nums2[median_b]);
                        }
                    }
                }else {
                    if(median_a - 1 >= 0 && nums2[median_b] < nums1[median_a - 1]){
                        if((m + n) % 2 == 0){
                            return (nums1[median_a] + nums1[median_a - 1]) * 1.0 / 2;
                        }else {
                            if(median_a + median_b < (m  - median_a - 1 + n -median_b - 1)){
                                return Math.max(nums1[median_a], nums2[median_b]);
                            }else {
                                return Math.min(nums1[median_a], nums2[median_b]);
                            }
                        }
                    }else if(median_a + 1 < n && nums2[median_b] > nums1[median_a + 1]){
                        if((m + n) % 2 == 0){
                            return (nums1[median_a] + nums1[median_a + 1]) * 1.0 / 2;
                        }else {
                            if(median_a + median_b < (m  - median_a - 1 + n -median_b - 1)){
                                return Math.max(nums1[median_a], nums2[median_b]);
                            }else {
                                return Math.min(nums1[median_a], nums2[median_b]);
                            }
                        }
                    }else{
                        return Math.PI;
                    }
                }
            }else if(((median_a - 1 >= 0 && nums2[median_b] > nums1[median_a - 1]) || median_a - 1 < 0) && ((median_a + 1 < n && nums2[median_b] < nums1[median_a + 1]) || median_a + 1 >= m)) {
                if (((median_b - 1 >= 0 && nums1[median_a] > nums2[median_b - 1]) || median_b - 1 < 0) && ((median_b + 1 < n && nums1[median_a] < nums2[median_b + 1]) || median_b + 1 >= n)) {
                    if ((m + n) % 2 == 0) {
                        return (nums1[median_a] + nums2[median_b]) * 1.0 / 2;
                    } else {
                        if (median_a + median_b < (m - median_a - 1 + n - median_b - 1)) {
                            return Math.max(nums1[median_a], nums2[median_b]);
                        } else {
                            return Math.min(nums1[median_a], nums2[median_b]);
                        }
                    }
                } else {
                    if (median_b - 1 >= 0 && nums1[median_a] > nums2[median_b - 1]) {
                        if ((m + n) % 2 == 0) {
                            return (nums2[median_a] + nums2[median_b - 1]) * 1.0 / 2;
                        } else {
                            if (median_a + median_b < (m - median_a - 1 + n - median_b - 1)) {
                                return Math.max(nums1[median_a], nums2[median_b]);
                            } else {
                                return Math.min(nums1[median_a], nums2[median_b]);
                            }
                        }
                    } else if (median_b + 1 < n && nums1[median_a] < nums2[median_b + 1]) {
                        if ((m + n) % 2 == 0) {
                            return (nums1[median_a] + nums2[median_b + 1]) * 1.0 / 2;
                        } else {
                            if (median_a + median_b < (m - median_a - 1 + n - median_b - 1)) {
                                return Math.max(nums1[median_a], nums2[median_b]);
                            } else {
                                return Math.min(nums1[median_a], nums2[median_b]);
                            }
                        }
                    } else {
                        return Math.PI;
                    }
                }
            }else if(median_b - 1 >= 0 && nums1[median_a] < nums2[median_b - 1]){
                // nums1 go right, nums2 go left
                start_a = median_a + 1 < m ? median_a + 1 : median_a;
                end_b = median_b - 1 >= 0 ? median_b - 1 : median_b;
            }else {
                start_b = median_b + 1 < n ? median_b + 1 : median_b;
                end_a = median_a - 1 >= 0? median_a - 1 : median_a;
            }
        }
    }

    // Solution from LeetCode
    public double findMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = iMin + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = iMax - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) throws Exception
    {
        MedianOfTwoSortedArray medianOfTwoSortedArray = new MedianOfTwoSortedArray();

        int[] nums1 = new int[]{4, 7, 9, 15, 16};
        int[] nums2 = new int[] {8, 17, 55, 77, 99};

        double median = medianOfTwoSortedArray.findMedianSortedArrays1(nums1, nums2);
        System.out.println(median);
    }



}
