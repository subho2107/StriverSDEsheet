//problem link:https://www.interviewbit.com/problems/minimum-characters-required-to-make-a-string-palindromic/

public class MinimumCharactersNeededToBeInsertedInTheBeginningToMakeItPalindromic {
    public boolean isPalindrome(String word){
        int n = word.length();
        for (int i = 0; i < n / 2; i++) {
            if (word.charAt(i) != word.charAt(n-i-1))
                return false;
        }
        return true;
    }
    //Time Complexity:O(n^2)
    //Space complexity: O(1)
    public int getMinCharsAtFirstToMakePalindromic(String word){
        int n = word.length(), lastPosPalin = -1;
        String curr = "";
        for (int i = 0; i < n; i++) {
            curr += word.charAt(i);
            if (isPalindrome(curr))
                lastPosPalin = i;
        }
        return n-1-lastPosPalin;
    }
    public String getReverse(String word){
        return new StringBuilder(word).reverse().toString();
    }
    public void getLPS(String word, int [] lps){
        int n = word.length();
        for (int i = 1; i < n; i++) {
            int j = lps[i-1];
            while (j > 0 && word.charAt(j) != word.charAt(i))
                j = lps[j-1];
            if (word.charAt(j) == word.charAt(i))
                j++;
            lps[i] = j;
        }
    }
    //Time Complexity:O(n)
    //Space complexity: O(2n)
    public int getMinCharsAtFirstToMakePalindromic2(String word) {
        int n = word.length();
        String rev = getReverse(word);
        int [] lps = new int[n+1];
        getLPS(word+'#', lps);
        int prevVal = 0, maxLenPalin = 0;
        for (int i = 0; i < n; i++) {
            int j = prevVal;
            while (j > 0 && rev.charAt(i) != word.charAt(j))
                j = lps[j-1];
            if (rev.charAt(i) == word.charAt(j))
                j++;
            maxLenPalin = j;
            prevVal = j;
        }

        return n-maxLenPalin;
    }
    public static void main(String[] args) {
        System.out.println(new MinimumCharactersNeededToBeInsertedInTheBeginningToMakeItPalindromic().getMinCharsAtFirstToMakePalindromic2("ABC"));
    }
}
