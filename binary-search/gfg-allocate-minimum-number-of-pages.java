// problem statement https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        
        if (N<M)
            return -1;
        int start = getMax(A,N);
        int end = getSum(A,N);
        int mid;
        int ans = -1;
        
        while (start <= end) {
            mid = start + (end - start)/2;
            if (isValid(A,N,M,mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    
    public static int getMax(int[]A,int N) {
        int max = -1;
        for (int i=0;i<N;i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }
    
    public static int getSum(int[]A,int N) {
        int sum = 0;
        for (int i=0;i<N;i++) {
            sum += A[i];
        }
        return sum;
    }
    
    public static boolean isValid(int[]A,int N,int M, int max) {
        int noStudents = 0;
        int currSum = 0;
        for (int i=0;i<N;i++) {
            currSum+= A[i];
            if (currSum > max) {
                noStudents++;
                currSum = A[i];
            }
        }
        if (currSum != 0)
            noStudents++;
        return noStudents <= M;
    }
};