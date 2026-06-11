class Solution {
    public int longestConsecutive(int[] nums) {
        int max_len = 0;

        Set<Integer> s = new HashSet<>();
        for(int num : nums)
            s.add(num);
        
        for(int i = 0; i < nums.length; i++) {
            int elem = nums[i];
            int curr_len = 1;

            while(s.contains(elem-1)) {
                curr_len++;
                elem--;
            }

            max_len = Math.max(max_len, curr_len);
        }

        return max_len;
    }
}
