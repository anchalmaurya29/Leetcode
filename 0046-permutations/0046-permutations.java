class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), ans);
        return ans;
    }

    void backtrack(int[] nums, boolean[] vis, List<Integer> list,
                   List<List<Integer>> ans) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) continue;

            vis[i] = true;
            list.add(nums[i]);

            backtrack(nums, vis, list, ans);

            list.remove(list.size() - 1);
            vis[i] = false;
        }
    }
}