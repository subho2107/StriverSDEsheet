//problem link:https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
import java.io.*;
import java.util.*;

public class CountInversions {
    //Time Complexity:O(nlogn)
    //Space complexity: O(n)
    static long mergeAndCnt(long [] arr, int l,  int mid, int r){
        long [] left = new long[mid-l+1], right = new long[r-mid];
        for(int i = 0; i < left.length; i++)
            left[i] = arr[i+l];

        for(int i = 0; i < right.length; i++)
            right[i] = arr[i+mid+1];

        long mergeCost = 0;
        int i = l, leftPos = 0, rightPos = 0;
        while(leftPos < left.length && rightPos < right.length){
            if(right[rightPos] < left[leftPos]){
                mergeCost += mid - (leftPos+l) + 1;
                arr[i++] = right[rightPos++];
            }
            else
                arr[i++] = left[leftPos++];
        }
        while(leftPos < left.length){
            arr[i++] = left[leftPos++];
        }
        return mergeCost;
    }
    static long mergeSortAndCnt(long [] arr, int l, int r){
        long cnt = 0;
        if(l < r){
            int mid = l + (r-l)/2;
            cnt += mergeSortAndCnt(arr, l, mid);
            cnt += mergeSortAndCnt(arr, mid+1, r);
            cnt += mergeAndCnt(arr, l, mid, r);
        }
        return cnt;
    }
    static long inversionCount(long[] arr, long N)
    {
        // Your Code Here
        return mergeSortAndCnt(arr, 0, (int)N-1);
    }
    //Time Complexity:O(n^2)
    //Space complexity: O(1)
    static long inversionCount2(long[] arr, long N)
    {
        // Your Code Here
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (arr[j] < arr[i])
                    cnt++;
            }
        }
        return cnt;
    }
}
