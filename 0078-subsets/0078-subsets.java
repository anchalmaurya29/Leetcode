class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    void backtrack(int i, int[] nums, List<Integer> cur,
                   List<List<Integer>> ans) {
        ans.add(new ArrayList<>(cur));

        for (int j = i; j < nums.length; j++) {
            cur.add(nums[j]);
            backtrack(j + 1, nums, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }
}