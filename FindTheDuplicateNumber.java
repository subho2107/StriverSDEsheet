//problem link:https://leetcode.com/problems/find-the-duplicate-number/
import java.io.*;
import java.util.*;

public class FindTheDuplicateNumber {
    //Time complexity:O(nlogn)
    //Space complexity:O(1)
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1])
                return nums[i];
        }
        return -1;
    }
    //Time complexity:O(n)
    //Space complexity:O(n)
    public int findDuplicate2(int[] nums) {
        int n = nums.length;
        int [] freq = new int[n];
        for(int num : nums){
            if(++freq[num] == 2)
                return num;
        }
        return -1;
    }
    //Time complexity:O(n)
    //Space complexity:O(1)
    public int findDuplicate3(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
