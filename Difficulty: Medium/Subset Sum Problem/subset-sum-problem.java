//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    static Boolean isSubsetSum(int arr[], int target) {
        // code here
        
        int ind=arr.length-1;
        Boolean dp[][]=new Boolean[ind+1][target+1];
        
        
        return solve(arr,target,ind,dp);
    
    }
    
    public static boolean solve(int[] arr,int target,int ind,Boolean[][] dp){
        if(target==0){
            return true;
        }
        if(ind==0){
            return target==arr[0];
        }
        if(dp[ind][target]!=null){
            return dp[ind][target];
        }
        boolean nottake=solve(arr,target,ind-1,dp);
        
        boolean take=false;
        
        if(target>=arr[ind]){
            take=solve(arr,target-arr[ind],ind-1,dp);
        }
        
        return dp[ind][target]=take || nottake;
    }
}