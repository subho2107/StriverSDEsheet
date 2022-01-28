import java.io.*;
import java.util.*;

public class RabinKarp {
    public int strStr(String haystack, String needle) {
        int n = needle.length(), m = haystack.length();
        if(n == 0)
            return 0;
        if(m == 0)
            return -1;
        int p = 31, mod = (int)(1e9+7);
        long [] powOfP = new long[Math.max(n, m)];
        powOfP[0] = 1;
        for(int i = 1; i < powOfP.length; i++)
            powOfP[i] = (powOfP[i-1] * p)%mod;
        long [] hashHayStack = new long[m+1];
        for(int i = 0; i < m; i++)
            hashHayStack[i+1] = (hashHayStack[i] + (haystack.charAt(i)-'a'+1)*powOfP[i])%mod;
        long hashNeedle = 0;
        for(int i = 0; i < n; i++)
            hashNeedle = (hashNeedle + (needle.charAt(i)-'a'+1)*powOfP[i])%mod;

        for(int i = 0; i+n-1 < m; i++){
            long substringHash = (hashHayStack[i+n]+mod-hashHayStack[i])%mod;
            if(substringHash == (hashNeedle*powOfP[i])%mod)
                return i;
        }
        return -1;
    }
}
