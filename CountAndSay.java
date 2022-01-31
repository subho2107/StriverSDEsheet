//problem link:https://leetcode.com/problems/count-and-say/

public class CountAndSay {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        String prev = countAndSay(n-1);
        char ch = prev.charAt(0);
        int freq = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < prev.length(); i++){
            if(prev.charAt(i) != ch){
                sb.append(freq);
                sb.append(ch);
                ch = prev.charAt(i);
                freq = 0;
            }
            freq++;
        }
        sb.append(freq);
        sb.append(ch);
        return sb.toString();
    }
}
