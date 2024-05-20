class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int sum = 0;
        Node temp = null;
        while (head != null) {
            for (temp = head.next ; temp != null; temp = temp.next) {
                sum = head.data + temp.data;
                if (sum == target) {
                    ArrayList<Integer> ans = new ArrayList<Integer>();
                    ans.add(head.data);
                    ans.add(temp.data);
                    result.add(ans);
                } else {
                    if (sum > target)
                        break;
                }
            }
            head = head.next;
        }
        return result;
    }
}