class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();

        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(!s.add(nums[i]))
                return true;
        }

        return false;
    }
}