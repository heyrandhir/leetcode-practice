class RangeFreqQuery {

    private final Node head;

    public RangeFreqQuery(int[] arr) {
        head = buildTree(0, arr.length - 1, arr);
    }
    
    public int query(int left, int right, int value) {
        return query(head, left, right, value);
    }

    private int query(Node head, int left, int right, int value) {

        if(head.leftRange > right || head.rightRange < left) {
            return 0;
        }

        if(head.leftRange >= left && head.rightRange <= right) {
            return head.freqs.getOrDefault(value, 0);
        }

        return query(head.leftChild, left, right, value) + query(head.rightChild, left, right, value);
    }

    private static Node buildTree(int left, int right, int[] arr) {

        if(left == right) {
            Map<Integer, Integer> freqs = new HashMap<>();
            freqs.put(arr[left], 1);
            return new Node(left, right, freqs);
        }

        var mid = (left + right) / 2;

        var head = new Node(left, right);
        head.leftChild = buildTree(left, mid, arr);
        head.rightChild = buildTree(mid + 1, right, arr);
        
        Map<Integer, Integer> freqs = new HashMap<>();

        head.leftChild.freqs.forEach((key, value) -> 
        freqs.merge(key, value, (v1, v2) -> v1 + v2));

        head.rightChild.freqs.forEach((key, value) -> 
        freqs.merge(key, value, (v1, v2) -> v1 + v2));
        
        head.freqs = freqs;

        return head;
    }

    private static class Node {
        int leftRange;
        int rightRange;
        Node leftChild;
        Node rightChild;
        Map<Integer, Integer> freqs = new HashMap<>();

        Node(int leftRange, int rightRange) {
            this.leftRange = leftRange;
            this.rightRange = rightRange;
        }

        Node(int leftRange, int rightRange, Map<Integer, Integer> freqs) {
            this.leftRange = leftRange;
            this.rightRange = rightRange;
            this.freqs = freqs;
        }
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */