// problem statement https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        int mid;

        while (start <= end) {
            mid = start + (end - start)/2;
            if (nums[mid] == target) {
                return true;
            }

            while (start < mid && nums[start] == nums[mid]) {
                start+=1;
            }

            while (mid < end && nums[mid] == nums[end]) {
                end-=1;
            }

            if (nums[mid]>=nums[start]) {
                // left half is sorted
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // right half is sorted
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return false;
    }
}