class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;

                for (char c = '1'; c <= '9'; c++) {
                    if (valid(board, i, j, c)) {
                        board[i][j] = c;

                        if (solve(board))
                            return true;

                        board[i][j] = '.';
                    }
                }

                return false;
            }
        }
        return true;
    }

    boolean valid(char[][] board, int r, int c, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == num || board[i][c] == num)
                return false;

            int x = (r / 3) * 3 + i / 3;
            int y = (c / 3) * 3 + i % 3;

            if (board[x][y] == num)
                return false;
        }

        return true;
    }
}