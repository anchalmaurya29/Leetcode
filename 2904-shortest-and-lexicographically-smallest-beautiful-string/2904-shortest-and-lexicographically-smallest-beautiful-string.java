class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int first = -1, bestLen = Integer.MAX_VALUE;
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (first == -1)
                    first = i;

                if (i - first + 1 > 0) {
                    int count = 0;

                    for (int j = first; j <= i; j++)
                        if (s.charAt(j) == '1')
                            count++;

                    if (count == k) {
                        String cur = s.substring(first, i + 1);

                        if (cur.length() < bestLen ||
                            (cur.length() == bestLen && cur.compareTo(ans) < 0)) {
                            bestLen = cur.length();
                            ans = cur;
                        }

                        first++;
                        while (first < s.length() && s.charAt(first) != '1')
                            first++;
                    }
                }
            }
        }

        return ans;
    }
}