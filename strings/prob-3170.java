class Solution {
    public String clearStars(String s) {
        HashSet<Integer> removeSet = new HashSet<>();
        PriorityQueue<Character> pq = new PriorityQueue<>();

        ArrayList<ArrayList<Integer>> indices = new ArrayList<>();
        for (int i = 0; i<26;i++) {
            indices.add(new ArrayList<>());
        }

        for (int i = 0;i<s.length();i++) {
            Character currChar = s.charAt(i);
            if ( currChar == '*') {
                removeSet.add(i);

                Character charToRemove = pq.peek();
                int index = indices.get((int) charToRemove - 'a').get(indices.get((int) charToRemove - 'a').size() - 1);
                indices.get((int) charToRemove - 'a').remove(indices.get((int) charToRemove - 'a').size() - 1);
                removeSet.add(index);
                if (indices.get((int) charToRemove - 'a').size() == 0)
                    pq.remove(charToRemove);
            } else {
                pq.add(currChar);
                indices.get((int) currChar - 'a').add(i);
            }
        }
        
        StringBuilder res = new StringBuilder();
        for (int i = 0; i<s.length();i++) {
            if (!removeSet.contains(i))
                res.append(s.charAt(i));
        }
        return res.toString();
    }
}