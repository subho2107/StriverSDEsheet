//problem link:https://leetcode.com/problems/next-permutation/
import java.io.*;
import java.util.*;

public class NextPermutation {
    //Time Complexity:O(n)
    //Space complexity: O(1)
    public void reverse(int [] arr, int start, int end){
        int temp;
        for (int i = 0; i < (end-start+1)/2; i++) {
            temp = arr[start+i];
            arr[start+i] = arr[end-i];
            arr[end-i] = temp;
        }
    }
    public void nextPermutation(int[] nums) {
        int pos = -1, n = nums.length;
        if(n == 1)
            return;
        for(int i = n-1; i >= 1; i--){
            pos = i;
            if(nums[i] > nums[i-1])
                break;
        }
        if(pos == 1 && nums[pos] < nums[pos-1]){
            reverse(nums, 0, n-1);
            return;
        }
        int num = nums[pos-1], greaterPos = -1;
        for(int i = n-1; i >= pos; i--){
            if(nums[i] > num){
                greaterPos = i;
                break;
            }
        }
        if(greaterPos == -1)
            return;
        nums[pos-1] = nums[greaterPos];
        nums[greaterPos] = num;
        reverse(nums, pos, n-1);
    }
    //Time Complexity:O(n!.n)
    //Space complexity: O(n^2)
    int [] ans, currPerm;
    boolean found;
    public boolean generatePermutation(int [] orgArr, int [] arr, int pos, HashSet<Integer>usedPosition){
        if (pos == arr.length){
            boolean check = true;
            for (int i = 0; i < arr.length; i++) {
                if (orgArr[i] != currPerm[i]){
                    check = false;
                    break;
                }
            }
            if (check)
                found = true;
            else if (found){
                ans = Arrays.copyOf(currPerm, currPerm.length);
                return true;
            }
            return false;
        }
        int prev = -1;
        for (int i = 0; i < arr.length; i++) {
            if (!usedPosition.contains(i) && arr[i] != prev){
                currPerm[pos] = arr[i];
                usedPosition.add(i);
                if (generatePermutation(orgArr, arr, pos+1, usedPosition))
                    return true;
                usedPosition.remove(i);
                prev = arr[i];
            }
        }
        return false;
    }
    public void nextPermutation2(int[] nums) {
        int n = nums.length;
        found = false;
        ans = new int[n];
        currPerm = new int[n];
        int [] dup = Arrays.copyOf(nums,  nums.length);
        Arrays.sort(dup);
        found = generatePermutation(nums, dup, 0, new HashSet<>());
        if(!found){
            for(int i = 0; i < nums.length; i++)
                nums[i] = dup[i];
            return;
        }
        for(int i = 0; i < nums.length; i++)
            nums[i] = ans[i];
    }
}
