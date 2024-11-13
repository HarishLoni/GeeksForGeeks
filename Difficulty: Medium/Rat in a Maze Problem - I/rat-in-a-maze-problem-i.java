//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        ArrayList<String> list=new ArrayList<>();
        int n=mat.length;
        int m=mat[0].length;
        int[][] vis=new int[n][m];
        if(mat[0][0]==1){
            vis[0][0]=1;
            solve(mat,list,"",0,0,n,m,vis);
        }
        
        return list;
    }
    
    public static void solve(int[][] arr,List<String> list,String ans,int i,int j,int n,int m,int[][] vis){
        if(i==n-1 && j==m-1){
            list.add(ans);
            return;
        }
        if(i+1<n && vis[i+1][j]==0 && arr[i+1][j]==1){
            vis[i+1][j]=1;
            solve(arr,list,ans+"D",i+1,j,n,m,vis);
            vis[i+1][j]=0;
        }
        
        if(j-1>=0 && vis[i][j-1]==0 && arr[i][j-1]==1){
            vis[i][j-1]=1;
            solve(arr,list,ans+"L",i,j-1,n,m,vis);
            vis[i][j-1]=0;
        }
        if(j+1<n && vis[i][j+1]==0 && arr[i][j+1]==1){
            vis[i][j+1]=1;
            solve(arr,list,ans+"R",i,j+1,n,m,vis);
            vis[i][j+1]=0;
        }
        if(i-1>=0 && vis[i-1][j]==0 && arr[i-1][j]==1){
            vis[i-1][j]=1;
            solve(arr,list,ans+"U",i-1,j,n,m,vis);
            vis[i-1][j]=0;
        }
        
    }
}