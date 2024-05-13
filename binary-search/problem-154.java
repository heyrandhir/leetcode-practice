// problem statement https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
class Solution {
    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length -1;
        int mid;

        while (start <= end ) {
            mid = start + (end - start)/2;
            if (nums[mid] == nums[end]) {
                end-=1;
            } else if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}