class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < n - 2; i++) {
            int first = nums[i];
            int l = i+1, r = n - 1;
            while(l < r) {
                if(first + nums[l] + nums[r] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(first);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    set.add(list);
                    l++;
                    r--;
                } else if(first + nums[l] + nums[r] > 0)
                    r--;
                else
                    l++;
            }
        }

        return new ArrayList<>(set);
    }
}
