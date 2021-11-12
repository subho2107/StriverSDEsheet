//problem link:https://leetcode.com/problems/3sum/
import java.io.*;
import java.util.*;

public class ThreeSum {
    //Time Complexity:O(n^2)
    //Space complexity: O(m)
    public  List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return List.of();
        Arrays.sort(nums);
        List<List<Integer>>triplets = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(i != 0 && nums[i] == nums[i-1])
                continue;
            int low = i+1, high = n-1, sum = -nums[i];
            while(low < high){
                if(nums[low]+nums[high] == sum){
                    triplets.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while(low < high && nums[low] == nums[low+1])low++;
                    while(high > low && nums[high] == nums[high-1])high--;
                    low++;
                    high--;
                }
                else if(nums[high]+nums[low] < sum)
                    low++;
                else
                    high--;
            }
        }
        return triplets;
    }
    //Time Complexity:O(n^3)
    //Space complexity: O(m)
    public  List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return List.of();
        Arrays.sort(nums);
        List<List<Integer>>triplets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(i != 0 && nums[i] == nums[i-1])
                continue;
            for (int j = i+1; j < n; j++) {
                if(j != i+1 && nums[j] == nums[j-1])
                    continue;
                for (int k = j + 1; k < n; k++) {
                    if(k != j+1 && nums[k] == nums[k-1])
                        continue;
                    if (nums[i] + nums[j] + nums[k] == 0)
                        triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return triplets;
    }
}
