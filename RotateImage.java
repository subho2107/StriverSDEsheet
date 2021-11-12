//problem link:https://leetcode.com/problems/rotate-image/
import java.io.*;
import java.util.*;

public class RotateImage {
    //Time Complexity:O(n^2)
    //Space complexity: O(1)
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int r = 0, c = 0, gap = n-1;
        while(r <= n/2 && c <= n/2){
            for(int i = 0; i < gap; i++){
                int [][] pos = {{r, c+i}, {r+i, c+gap}, {r+gap, c+gap-i}, {r+gap-i, c}};
                int [] vals = new int[4];
                for(int j = 0; j < 3; j++){
                    vals[j+1] = matrix[pos[j][0]][pos[j][1]];
                }
                vals[0] = matrix[pos[3][0]][pos[3][1]];
                for(int j = 0; j < 4; j++){
                    matrix[pos[j][0]][pos[j][1]] = vals[j];
                }
            }
            r++;
            c++;
            gap-=2;
        }
    }
    //Time Complexity:O(n^2)
    //Space complexity: O(1)
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
}
