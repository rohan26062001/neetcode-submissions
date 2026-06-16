class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int rem = target - nums[i];
            if(map.get(rem) != null) {
                int[] ans = new int[2];
                if(i < map.get(rem)) {
                    ans[0] = i;
                    ans[1] = map.get(rem);
                } else {
                    ans[1] = i;
                    ans[0] = map.get(rem);
                }
                return ans;
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{-1,-1};
    }
}
