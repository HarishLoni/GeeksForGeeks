//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int arr[] = new int[str.length]; // Creating integer array from the input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            ArrayList<Integer> result = new Solution().subsetSums(arr);
            Collections.sort(result);
            // Printing the result in space-separated format
            for (int i = 0; i < result.size(); i++) {
                if (i != 0) System.out.print(" ");
                System.out.print(result.get(i));
            }
            System.out.println();    // Print new line after each test case
            System.out.println("~"); // Print new line after each test case
        }
    }
}

// } Driver Code Ends


// User function Template for Java//User function Template for Java
class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        int n=arr.length;
        Arrays.sort(arr);
        ans(arr,0,n,list,0);
        Collections.sort(list);
        
        return list;
      
        
    }
    
    public static void ans(int[] arr,int ind,int n,ArrayList<Integer> list,int sum){
        if(ind==n){
            list.add(sum);
            return;
        }
        
        ans(arr,ind+1,n,list,sum+arr[ind]);
        
        ans(arr,ind+1,n,list,sum);
    }
}