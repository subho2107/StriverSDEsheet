//problem link:https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
import java.io.*;
import java.util.*;

public class FindMissingAndRepeating {
    //Time Complexity:O(n)
    //Space complexity: O(n)
    int[] findTwoElement(int[] arr, int n) {
        int missingNo = -1, duplicateNo = -1;
        int [] freq = new int[n+1];
        for(int num : arr){
            freq[num]++;
        }
        for(int i = 1; i <= n; i++){
            if(freq[i] == 0)
                missingNo = i;
            else if(freq[i] == 2)
                duplicateNo = i;
        }
        return new int[]{duplicateNo, missingNo};
    }
    //Time Complexity:O(n)
    //Space complexity: O(1)
    int[] findTwoElement2(int[] arr, int n) {
        int missingNo = -1, duplicateNo = -1;
        long sumUptoN = (long)n*(n+1)/2, squareSumUptoN = (long)n*(n+1)*(2L *n+1)/6, arrSum = 0, squareArrSum = 0;
        for(int num : arr){
            arrSum += num;
            squareArrSum += (long)num*num;
        }
        long valA = arrSum - sumUptoN, valB = (squareArrSum - squareSumUptoN)/valA;
        missingNo = (int)((valB - valA)/2);
        duplicateNo = (int)(missingNo+valA);
        return new int[]{duplicateNo, missingNo};
    }
}
