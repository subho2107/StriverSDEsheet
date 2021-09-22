//prob link: https://leetcode.com/problems/maximum-subarray/
import java.io.*;
import java.util.*;

public class MaximumSubarray {
    //Time complexity:O(n)
    //Space complexity:O(1)
    public int maxSubArray(int[] nums) {
        int localMax = 0, globalMax = nums[0], n = nums.length;
        for(int i = 0; i < n; i++){
            localMax += nums[i];
            globalMax = Math.max(globalMax, localMax);
            if(localMax < 0){
                localMax = 0;
                continue;
            }
        }
        return globalMax;
    }
    //Time complexity:O(n^2)
    //Space complexity:O(1)
    public int maxSubArray2(int[] nums) {
        int maxSum = nums[0], n = nums.length;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
