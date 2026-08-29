class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row : board)
            Arrays.fill(row, '.');

        backtrack(0, board, new HashSet<>(), new HashSet<>(),
                  new HashSet<>(), ans);

        return ans;
    }

    void backtrack(int r, char[][] board, Set<Integer> col,
                   Set<Integer> d1, Set<Integer> d2,
                   List<List<String>> ans) {

        if (r == board.length) {
            List<String> res = new ArrayList<>();
            for (char[] row : board)
                res.add(new String(row));
            ans.add(res);
            return;
        }

        for (int c = 0; c < board.length; c++) {
            if (col.contains(c) || d1.contains(r - c) || d2.contains(r + c))
                continue;

            board[r][c] = 'Q';
            col.add(c);
            d1.add(r - c);
            d2.add(r + c);

            backtrack(r + 1, board, col, d1, d2, ans);

            board[r][c] = '.';
            col.remove(c);
            d1.remove(r - c);
            d2.remove(r + c);
        }
    }
}