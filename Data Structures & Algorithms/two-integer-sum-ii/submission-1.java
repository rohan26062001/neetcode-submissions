class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while(l < r) {
            int sum = nums[l] + nums[r];

            if(sum == target){
                int[] arr = new int[2];
                arr[0] = l+1; arr[1] = r+1;
                return arr;
            } else if(sum > target) {
                r--;
            } else {
                l++;
            }
        }
    
        return new int[]{-1, -1};
    }
}
