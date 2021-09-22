//problem link:https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
import java.io.*;
import java.util.*;

public class MergeTwoSortedArrays {
    //Time complexity:O(mn)
    //Space complexity:O(1)
    public static void merge(long[] arr1, long[] arr2, int n, int m)
    {
        // code here
        for(int i = 0; i < n; i++){
            if(arr1[i] > arr2[0]){
                arr1[i] = arr2[0]^arr1[i]^(arr2[0] = arr1[i]);
                int pos = 0;
                while(pos < m-1 && arr2[pos] > arr2[pos+1]){
                    arr2[pos] = arr2[pos+1]^arr2[pos]^(arr2[pos+1] = arr2[pos]);
                    pos++;
                }
            }
        }
    }
    //Time complexity:O((m+n)log(m+n))
    //Space complexity:O(1)
    public static void merge2(long[] arr1, long[] arr2, int n, int m)
    {
        // code here
        int gap = (n+m)/2+(n+m)%2;
        while(gap >= 1){
            int i = 0;
            for(; i+gap < n; i++){
                if(arr1[i+gap] < arr1[i])
                {
                    long temp = arr1[i];
                    arr1[i] = arr1[i+gap];
                    arr1[i+gap] = temp;
                }
            }
            int j = gap > n?gap-n:0;
            for(;j < m && i < n; j++, i++){
                if(arr1[i] > arr2[j]) {
                    long temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
            if(j < m){
                for(j = 0; j+gap < m; j++){
                    if(arr2[j+gap] < arr2[j])
                    {
                        long temp = arr2[j];
                        arr2[j] = arr2[j+gap];
                        arr2[j+gap] = temp;
                    }
                }
            }
            if(gap == 1)
                break;
            gap = gap/2 + gap%2;
        }
    }
}
