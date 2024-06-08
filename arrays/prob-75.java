class Solution {
    public void sortColors(int[] nums) {
        
        // bruteforce approach 

        // HashMap<Integer,Integer> memo = new HashMap<>();
        // for (int num: nums) {
        //     if (!memo.containsKey(num)) {
        //         memo.put(num,1);
        //     } else {
        //         memo.put(num,memo.get(num)+1);
        //     }
        // }


        // int count = 0;
        // for (int color = 0; color <3; color++) {
        //     if (memo.containsKey(color)) {
        //         for (int i=0;i<memo.get(color);i++) {
        //             nums[count+i] = color;
        //         }
        //         count+=memo.get(color);
        //     }
        // }

        // optimised solution 
        while (s <= e && i <= e) {
            if (nums[i] == 0) {
                nums[i] = nums[s];
                nums[s] = 0;
                i++;
                s++; 
            } else if (nums[i] == 2) {
                nums[i] = nums[e];
                nums[e] = 2;
                e--;
            } else {
                i++;
            }
        }
    }
}