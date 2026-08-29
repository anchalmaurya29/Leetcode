class Solution {
    public int totalNQueens(int n) {
        return solve(0, n, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    int solve(int row, int n, Set<Integer> col,
              Set<Integer> d1, Set<Integer> d2) {

        if (row == n)
            return 1;

        int count = 0;

        for (int c = 0; c < n; c++) {
            if (col.contains(c) || d1.contains(row - c) || d2.contains(row + c))
                continue;

            col.add(c);
            d1.add(row - c);
            d2.add(row + c);

            count += solve(row + 1, n, col, d1, d2);

            col.remove(c);
            d1.remove(row - c);
            d2.remove(row + c);
        }

        return count;
    }
}