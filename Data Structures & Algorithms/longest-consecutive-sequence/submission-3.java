class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;

        Set<Integer> s = new HashSet<>();
        for(int num : nums) {
            s.add(num);
        }

        for(int i = 0; i < nums.length; i++) {
            if(s.contains(nums[i] - 1)) {
                int length = 1, num = nums[i];
                while(s.contains(num-1)){
                    length++;
                    num-=1;
                }
                maxLength = Math.max(maxLength, length);
            } else {
                maxLength = Math.max(maxLength, 1);
            }
        }

        return maxLength;
    }
}
