//{ Driver Code Starts
//Initial Template for Java




import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMissing(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    int findMissing(int[] arr, int n) {
        int d= (arr[n-1]-arr[0])/n;
        
        int a=0, l = n-1;
        while(a<=l){
            int m = a + (l-a)/2;
            
            if(arr[m] != arr[0]+m*d){
                l=m-1;
            }else{
                a=m+1;
            }
        }
        return arr[0] + a*d;
        
        // code here
    }
}
