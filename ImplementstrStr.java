//problem link:https://leetcode.com/problems/implement-strstr/

public class ImplementstrStr {
    //Time Complexity:O(m*n)
    //Space complexity: O(1)
    public int strStr(String haystack, String needle) {
        int lenHaystack = haystack.length(), lenNeedle = needle.length();
        if(lenNeedle == 0)
            return 0;
        if(lenHaystack == 0)
            return -1;
        for(int i = 0; i+lenNeedle-1 < lenHaystack; i++){
            boolean check = true;
            for(int j = 0; j < lenNeedle; j++){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    check = false;
                    break;
                }
            }
            if(check)
                return i;
        }
        return -1;
    }
    //Time Complexity:O(m+n)
    //Space complexity: O(n)
    private void makeLPS(String text, int [] lps){
        for(int i = 1; i < text.length(); i++){
            int j = lps[i-1];
            while(j > 0 && text.charAt(i) != text.charAt(j))
                j = lps[j-1];
            if(text.charAt(i) == text.charAt(j))
                j++;
            lps[i] = j;
        }
    }
    public int strStr2(String haystack, String needle) {
        int n = needle.length(), m = haystack.length();
        if(n == 0)
            return 0;
        if(m == 0)
            return -1;
        int [] lps = new int[n+1];
        makeLPS(needle+"#", lps);
        int prevVal = 0;
        for(int i = 0; i < m; i++){
            int j = prevVal;
            while(j > 0 && haystack.charAt(i) != needle.charAt(j))
                j = lps[j-1];
            if(haystack.charAt(i) == needle.charAt(j))
                j++;
            prevVal = j;
            if(j == n)
                return i-n+1;
        }
        return -1;
    }
}
