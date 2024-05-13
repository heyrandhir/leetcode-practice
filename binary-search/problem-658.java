// problem https://leetcode.com/problems/find-k-closest-elements/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        int pivot = -1;
        
        while (start <= end) {
            mid = start + (end - start)/2;
            if (arr[mid] < x) {
                pivot = mid;
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }

        int left = (pivot - k < 0) ? 0 : pivot - k;
        int right = (pivot + k > arr.length -1) ? arr.length -1 : pivot + k;

        while (right - left + 1 > k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left ++;
            } else {
                right --;
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (int i=left;i<=right;i++){
            ans.add(arr[i]);
        }
        return ans;

    }
}