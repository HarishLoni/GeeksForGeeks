//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public int longestkSubstr(String s, int k) {
        int l=0,r=0,n=s.length(),maxi=0;
        HashMap<Character,Integer> map=new HashMap<>();
        
        while(r<n){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            
            if(map.size()>k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            
            if(map.size()==k){
                int len=r-l+1;
                maxi=Math.max(maxi,len);
            }
            r++;
        }
        return (maxi<=0)?-1:maxi;
        
    }
}