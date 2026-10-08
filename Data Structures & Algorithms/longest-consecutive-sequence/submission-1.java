class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i < nums.length; i++)
            s.add(nums[i]);
        
        int maxLength = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!s.contains(nums[i]-1)) {
                int length = 0, num = nums[i];
                while(s.contains(num)) {
                    length++;
                    num++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
