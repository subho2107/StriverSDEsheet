//prob link: https://leetcode.com/problems/sort-colors/
import java.io.*;
import java.util.*;

public class SortColors {
    //Time complexity: O(2n)
    //Space complexity: O(1)
    public void sortColors(int[] nums) {
        int zeroCnt = 0, oneCnt = 0, twoCnt = 0, n = nums.length;
        for(int num : nums){
            if(num == 0)
                zeroCnt++;
            else if(num == 1)
                oneCnt++;
            else
                twoCnt++;
        }
        int onePos = zeroCnt, twoPos = zeroCnt+oneCnt;
        for(int i = 0; i < n; i++){
            if(i < onePos)
                nums[i] = 0;
            else if(i < twoPos)
                nums[i] = 1;
            else
                nums[i] = 2;
        }
    }
    //Time complexity: O(n)
    //Space complexity: O(1)
    public void sortColors2(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n-1, temp;
        while(mid <= high){
            switch(nums[mid]){
                case 0:
                    temp = nums[mid];
                    nums[mid] = nums[low];
                    nums[low] = temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp;
                    high--;
                    break;
            }
        }
    }
}
