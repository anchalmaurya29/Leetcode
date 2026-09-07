class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1_000_000_007;
        long dp = 1;
        long[] last = new long[26];

        for (char c : s.toCharArray()) {
            long newDp = (dp * 2 - last[c - 'a'] + mod) % mod;
            last[c - 'a'] = dp;
            dp = newDp;
        }

        return (int)((dp - 1 + mod) % mod);
    }
}