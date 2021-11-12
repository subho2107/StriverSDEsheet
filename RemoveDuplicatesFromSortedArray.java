//problem link:https://leetcode.com/problems/remove-duplicates-from-sorted-array/
import java.io.*;
import java.util.*;

public class RemoveDuplicatesFromSortedArray {
    //Time Complexity:O(n)
    //Space complexity: O(n)
    public int removeDuplicates2(int[] nums){
        Set<Integer>set = new LinkedHashSet<>();
        for(int num : nums)
            set.add(num);
        int i = 0;
        for(int num : set){
            nums[i++] = num;
        }
        return i;
    }
    //Time Complexity:O(n)
    //Space complexity: O(1)
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <= 1)
            return n;
        int a = 1, b = 1;
        while(b < n){
            if(nums[b] > nums[a-1]){
                nums[a] = nums[b];
                a++;
                b++;
            }
            else{
                while(b < n && nums[b] == nums[a-1])
                    b++;
            }
        }
        return a;
    }
}
