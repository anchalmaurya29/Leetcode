class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int[] heights = new int[matrix[0].length];
        int ans = 0;

        for (char[] row : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                heights[j] = row[j] == '1' ? heights[j] + 1 : 0;
            }

            ans = Math.max(ans, histogram(heights));
        }

        return ans;
    }

    int histogram(int[] h) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i <= h.length; i++) {
            int cur = i == h.length ? 0 : h[i];

            while (!stack.isEmpty() && h[stack.peek()] > cur) {
                int height = h[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }

            stack.push(i);
        }

        return max;
    }
}