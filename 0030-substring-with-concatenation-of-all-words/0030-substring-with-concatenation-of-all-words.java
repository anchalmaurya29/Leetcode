class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int n = words.length, len = words[0].length();

        Map<String, Integer> map = new HashMap<>();
        for (String w : words)
            map.put(w, map.getOrDefault(w, 0) + 1);

        for (int i = 0; i < len; i++) {
            int left = i, count = 0;
            Map<String, Integer> seen = new HashMap<>();

            for (int right = i; right + len <= s.length(); right += len) {
                String w = s.substring(right, right + len);

                if (!map.containsKey(w)) {
                    seen.clear();
                    count = 0;
                    left = right + len;
                    continue;
                }

                seen.put(w, seen.getOrDefault(w, 0) + 1);
                count++;

                while (seen.get(w) > map.get(w)) {
                    String x = s.substring(left, left + len);
                    seen.put(x, seen.get(x) - 1);
                    left += len;
                    count--;
                }

                if (count == n) {
                    ans.add(left);
                    String x = s.substring(left, left + len);
                    seen.put(x, seen.get(x) - 1);
                    left += len;
                    count--;
                }
            }
        }
        return ans;
    }
}