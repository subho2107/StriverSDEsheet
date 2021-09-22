//problem link: https://leetcode.com/problems/merge-intervals/
import java.io.*;
import java.util.*;

public class MergeIntervals {
    //Time complexity:O(n)
    //Space complexity:O(n)
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b)->{
            return a[0]-b[0];
        });
        List<int[]>list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int intervalStart = intervals[i][0], intervalEnd = intervals[i][1];
            while(i < n-1 && intervals[i+1][0] <= intervalEnd){
                i++;
                intervalEnd = Math.max(intervalEnd, intervals[i][1]);
            }
            list.add(new int[]{intervalStart, intervalEnd});
        }
        n = list.size();
        int[][]ans = new int[n][2];
        for(int i = 0; i < n; i++)
        {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }
        return ans;
    }
}
