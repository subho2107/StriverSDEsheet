import java.io.*;
import java.util.*;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String [] toSplit = version1.split("\\.");
        int n = toSplit.length;
        int [] version1Int = new int[n];
        for(int i = 0; i < n; i++)
            version1Int[i] = Integer.parseInt(toSplit[i]);
        toSplit = version2.split("\\.");
        int m = toSplit.length;
        for(int i = 0; i < Math.max(n, m); i++){
            int a = 0, b = 0;
            if(i < n)
                a = version1Int[i];
            if(i < m)
                b = Integer.parseInt(toSplit[i]);
            if(a > b)
                return 1;
            else if(a < b)
                return -1;
        }
        return 0;
    }
}
