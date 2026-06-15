class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, min = nums[0];
        
        while(l <= r) {
            if(nums[l] < nums[r]) {
                min = Math.min(nums[l], min);
                break;
            }

            int mid = l + (r - l) / 2;
            int midElem = nums[mid];
            min = Math.min(midElem, min);

            if(nums[l] <= nums[mid])
                l = mid+1;
            else
                r = mid-1; 
        }

        return min;
    }
}
