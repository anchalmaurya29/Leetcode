class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        
        for (int i = 1; i <= n; i++)
            nums.add(i);

        int fact = 1;
        for (int i = 1; i < n; i++)
            fact *= i;

        k--;

        StringBuilder ans = new StringBuilder();

        while (n > 0) {
            int index = k / fact;
            ans.append(nums.get(index));
            nums.remove(index);

            k %= fact;
            n--;

            if (n > 0)
                fact /= n;
        }

        return ans.toString();
    }
}