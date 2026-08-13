class SegmentTree {
    class Node {
        int maxRun, prefixRun, suffixRun, length;
        char firstChar, lastChar;
    }

    Node[] tree;
    char[] arr;
    int n;

    SegmentTree(String s) {
        arr = s.toCharArray();
        n = arr.length;
        tree = new Node[4 * n];
        build(1, 0, n - 1);
    }

    private void build(int idx, int l, int r) {
        tree[idx] = new Node();
        tree[idx].length = r - l + 1;
        if (l == r) {
            tree[idx].maxRun = tree[idx].prefixRun = tree[idx].suffixRun = 1;
            tree[idx].firstChar = tree[idx].lastChar = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(idx * 2, l, mid);
        build(idx * 2 + 1, mid + 1, r);
        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
    }

    private Node merge(Node left, Node right) {
        Node res = new Node();
        res.length = left.length + right.length;
        res.firstChar = left.firstChar;
        res.lastChar = right.lastChar;

        // prefix run
        res.prefixRun = left.prefixRun;
        if (left.prefixRun == left.length && left.lastChar == right.firstChar) {
            res.prefixRun += right.prefixRun;
        }

        // suffix run
        res.suffixRun = right.suffixRun;
        if (right.suffixRun == right.length && left.lastChar == right.firstChar) {
            res.suffixRun += left.suffixRun;
        }

        // max run
        res.maxRun = Math.max(left.maxRun, right.maxRun);
        if (left.lastChar == right.firstChar) {
            res.maxRun = Math.max(res.maxRun, left.suffixRun + right.prefixRun);
        }

        return res;
    }

    public void update(int pos, char val) {
        update(1, 0, n - 1, pos, val);
    }

    private void update(int idx, int l, int r, int pos, char val) {
        if (l == r) {
            arr[pos] = val;
            tree[idx].maxRun = tree[idx].prefixRun = tree[idx].suffixRun = 1;
            tree[idx].firstChar = tree[idx].lastChar = val;
            return;
        }
        int mid = (l + r) / 2;
        if (pos <= mid) update(idx * 2, l, mid, pos, val);
        else update(idx * 2 + 1, mid + 1, r, pos, val);
        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
    }

    public int query() {
        return tree[1].maxRun;
    }
}

class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        SegmentTree st = new SegmentTree(s);
        int[] ans = new int[queryIndices.length];
        for (int i = 0; i < queryIndices.length; i++) {
            st.update(queryIndices[i], queryCharacters.charAt(i));
            ans[i] = st.query();
        }
        return ans;
    }
}
