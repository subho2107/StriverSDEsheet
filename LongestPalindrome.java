import java.io.*;
import java.util.*;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int [] charFreq = new int[72];
        for(char ch : s.toCharArray()){
            int index = ch - 'a';
            if(ch >= 'A' && ch <= 'Z')
                index = ch - 'A'+26;
            charFreq[index]++;
        }
        int ans = s.length();
        boolean checkOneOdd = false;
        for(int freq : charFreq){
            if(freq % 2 == 1){
                if(checkOneOdd)
                    ans--;
                else
                    checkOneOdd = true;
            }
        }
        return ans;
    }
}
