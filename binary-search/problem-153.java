class Solution {
    public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length -1]) 
            return nums[0];
        
        int start = 0;
        int end = nums.length -1;
        int mid;

        while (start <= end ) {
            mid = start + (end - start)/2;
            if (mid < nums.length -1 && nums[mid] > nums[mid +1]) {
                return nums[mid+1];
            }

            if (mid > 0 && nums[mid] < nums[mid -1]) {
                return nums[mid];
            }
            
            if (nums[mid] >= nums[start])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}