class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            int element = nums[i];
            int complement = target - element;

            if(indices.containsKey(complement)) {
                return new int[]{indices.get(complement), i};
            } else {
                indices.put(element, i);
            }
        }

        return new int[]{-1, -1};
    }
}
