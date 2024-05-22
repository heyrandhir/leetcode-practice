class NumArray {
    int[] nums;
    int[] segmentTree;
    int size;

    public NumArray(int[] nums) {
        this.nums = nums;
        size = nums.length;
        segmentTree = new int[size*4];
        constructSegmentTree(nums,0,size-1,0);    
    }

    private void constructSegmentTree(int[] nums,int start, int end, int currIndex) {
        if (start > end)
            return;

        if (start == end) {
            segmentTree[currIndex] = nums[start];
            return;
        }

        int mid = start + (end -start)/2;
        constructSegmentTree(nums,start,mid,2*currIndex+1);
        constructSegmentTree(nums,mid+1,end,2*currIndex+2);
        segmentTree[currIndex] = segmentTree[2*currIndex+1] + segmentTree[2*currIndex+2]; 
    }
    
    public void update(int index, int val) {
        nums[index] = val;
        updateHelper(0,size-1,0,index,val);
    }

    public void updateHelper(int start, int end, int currIndex, int index, int val) {
        if (start > end)
            return;

        if (start == end) {
            if (start == index)
                segmentTree[currIndex] = nums[start];
            return;
        }

        int mid = start + (end -start)/2;
        if (index <= mid) {
            updateHelper(start,mid,(2*currIndex)+1,index,val);
        } else {
            updateHelper(mid+1,end,(2*currIndex)+2,index,val);
        }
        segmentTree[currIndex] = segmentTree[currIndex *2 + 1] + segmentTree[currIndex *2 + 2];
    }
    
    public int sumRange(int left, int right) {
        return sumRangeHelper(0,size-1,0,left,right);
    }

    public int sumRangeHelper(int start, int end, int currIndx, int left, int right) {
        if (start > end || start > right || end < left)
            return 0;
        
        if (start >= left && end <= right) {
            return segmentTree[currIndx];
        }

        int mid = start + (end - start)/2;
        return sumRangeHelper(start,mid,2*currIndx+1,left,right) + sumRangeHelper(mid+1,end,2*currIndx+2,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */