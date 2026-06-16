class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int num : nums)
            s.add(num);
        
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(s.contains(num - 1)) {
                int len = 1, temp = num;
                while(s.contains(temp - 1)) {
                    len++;
                    temp -= 1;
                }
                maxLen = Math.max(maxLen, len);
            } else {
                maxLen = Math.max(maxLen, 1);
            }
        }

        return maxLen;
    }
}
