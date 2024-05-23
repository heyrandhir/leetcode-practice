// https://www.geeksforgeeks.org/problems/range-minimum-query/1

//{ Driver Code Starts
    import java.util.*;
    import java.lang.*;
    
    class Minimum
    {
        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            
            while(t-- > 0)
            {
                int n = sc.nextInt();
                int arr[] = new int[n];
                
                for(int i = 0; i < n; i++)
                  arr[i] = sc.nextInt();
                  
                  GfG gfg = new GfG();
                int Q = sc.nextInt();
                
                
                int st[] = gfg.constructST(arr, n);
                int l,r;
                for(int i = 0; i < Q; i++)
                {
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    l = Math.min(a,b);
                    r = Math.max(a,b);
                    
                    System.out.print(gfg.RMQ(st, n, l, r) + " ");
                    
                }
                System.out.println();
            }
        }
    }
    // } Driver Code Ends
    
    
    /* The functions which 
    builds the segment tree */
    class GfG
    {
        static int st[];
        
        public static int[] constructST(int arr[], int n)
        {
            // Add your code here
            st = new int[n*4];
            constructSegmentTree(arr,0,arr.length-1,0);
            return st;
        }
        
        private static void constructSegmentTree(int[] nums,int start, int end, int currIndex) {
            if (start > end)
                return;
    
            if (start == end) {
                st[currIndex] = nums[start];
                return;
            }
    
            int mid = start + (end -start)/2;
            constructSegmentTree(nums,start,mid,2*currIndex+1);
            constructSegmentTree(nums,mid+1,end,2*currIndex+2);
            st[currIndex] = Math.min(st[2*currIndex+1],st[2*currIndex+2]); 
        }
        
        /* The functions returns the
          min element in the range
          from l and r */
        public static int RMQ(int st[], int n, int l, int r)
        {
           // Add your code here
           return RMQHelper(st,0,n-1,0,l,r);
        }
        
        public static int RMQHelper(int[] st, int start, int end, int currIndx, int left, int right) {
            if (start > end || start > right || end < left)
                return Integer.MAX_VALUE;
            
            if (start >= left && end <= right) {
                return st[currIndx];
            }
        
            int mid = start + (end - start)/2;
            return Math.min(RMQHelper(st,start,mid,2*currIndx+1,left,right),RMQHelper(st,mid+1,end,2*currIndx+2,left,right));
        }
        
        
    }