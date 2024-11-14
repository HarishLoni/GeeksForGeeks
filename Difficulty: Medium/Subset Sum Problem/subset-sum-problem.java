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
        return solve(arr,target,0,arr.length);
    }
    
    public static boolean solve(int arr[], int target,int i,int n){
        if(i==n){
        if(target==0){
            return true;
        }
        return false;
        }
        if(arr[i]<=target){
            return solve(arr,target-arr[i],i+1,n) || solve(arr,target,i+1,n);
        }
        return solve(arr,target,i+1,n);
    }
}