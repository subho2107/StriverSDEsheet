import java.io.*;
import java.util.*;

public class StringToIntegerAtoi {
    public int myAtoi(String s) {
        s = s.trim();
        int n = s.length(), maxVal = Integer.MAX_VALUE, minVal = Integer.MIN_VALUE;
        if(n == 0)
            return 0;
        char [] arr = s.toCharArray();
        long num = 0;
        boolean positive = true;
        int i = 0;
        if(!Character.isDigit(arr[0])){
            if(arr[0] == '-')
                positive = false;
            else if(arr[0] != '+')
                return 0;
            i++;
        }
        for(; i < n && Character.isDigit(arr[i]); i++){
            int digit = Character.getNumericValue(arr[i]);
            num = num*10 + digit;
            if(positive && num > maxVal)
                return maxVal;
            else if(-num < minVal)
                return minVal;
        }
        if(!positive)
            num *= -1;
        return (int)num;
    }
}
