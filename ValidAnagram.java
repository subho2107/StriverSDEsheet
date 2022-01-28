import java.io.*;
import java.util.*;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        if(lenS != lenT)
            return false;
        int [] freq = new int[26];
        for(int i = 0; i < lenS; i++){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }
        for(int i : freq){
            if(i != 0)
                return false;
        }
        return true;
    }
}
