import java.io.*;
import java.util.*;

public class PascalTriangle {
    //Time Complexity:O(numRows^2)
    //Space complexity: O(numRows^2)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>ans = new ArrayList<>();
        for(int line = 1; line <= numRows; line++){
            List<Integer>currLine = new ArrayList<>();
            currLine.add(1);
            for(int pos = 1; pos < line; pos++){
                int curr = 0, prev = 0;
                List<Integer>prevLine = ans.get(ans.size()-1);
                if(pos < prevLine.size())
                    curr = prevLine.get(pos);
                prev = prevLine.get(pos-1);
                currLine.add(prev+curr);
            }
            ans.add(currLine);
        }
        return ans;
    }
    //Time Complexity:O(numRows^3)
    //Space complexity: O(numRows^2)
    public int binomial(int n, int r){
        if(n - r < r)
            r = n-r;
        int ans = 1;
        for(int i = 0; i < r; i++){
            ans *= (n-i);
            ans /= (i+1);
        }
        return ans;
    }
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>>ans = new ArrayList<>();
        for(int line = 1; line <= numRows; line++){
            List<Integer>currLine = new ArrayList<>();
            for(int pos = 0; pos < line; pos++){
                currLine.add(binomial(line-1, pos));
            }
            ans.add(currLine);
        }
        return ans;
    }
    //Time Complexity:O(numRows^2)
    //Space complexity: O(numRows^2)
    public List<List<Integer>> generate3(int numRows) {
        List<List<Integer>>ans = new ArrayList<>();
        for(int line = 1; line <= numRows; line++){
            List<Integer>currLine = new ArrayList<>();
            int temp = 1;
            for(int pos = 1; pos <= line; pos++){
                currLine.add(temp);
                temp *= (line - pos);
                temp/=pos;
            }
            ans.add(currLine);
        }
        return ans;

    }
}
