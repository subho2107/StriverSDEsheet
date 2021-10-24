//problem link:https://leetcode.com/problems/set-matrix-zeroes/
import java.io.*;
import java.util.*;

public class SetMatrixZeroes {
    //Time Complexity:O(mn)
    //Space complexity: O(1)
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean checkRow = false, checkCol = false;
        for(int j = 0; j < m; j++)
            if(matrix[0][j] == 0)
                checkCol = true;
        for(int i = 0; i < n; i++)
            if(matrix[i][0] == 0)
                checkRow = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < n; i++){
            if(matrix[i][0] == 0)
            {
                for(int j = 0; j < m; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 1; j < m; j++){
            if(matrix[0][j] == 0){
                for(int i = 0; i < n; i++)
                    matrix[i][j] = 0;
            }
        }
        if(checkCol){
            for(int j = 0; j < m; j++)
                matrix[0][j] = 0;
        }
        if(checkRow){
            for(int i = 0; i < n; i++)
                matrix[i][0] = 0;
        }
    }
    //Time Complexity:O(mn)
    //Space complexity: O(m+n)
    public void setZeroes2(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        Set<Integer>rows = new HashSet<>(), cols = new HashSet<>();
        for(int i =0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int row : rows){
            for(int j = 0; j < m; j++)
                matrix[row][j] = 0;
        }
        for(int col : cols){
            for(int i = 0; i < n; i++)
                matrix[i][col] = 0;
        }
    }
}
