import java.io.*;
import java.util.*;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        int n = strs.length;
        for(int i = 1; i < n; i++){
            int j = 0;
            for(; j < strs[i].length() && j < prefix.length(); j++){
                if(prefix.charAt(j) != strs[i].charAt(j))
                    break;
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }
}
