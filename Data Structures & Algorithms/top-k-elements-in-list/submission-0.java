class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        map.forEach((key, value) -> {
            list.get(value).add(key);
        });

        return topK(list, k);
    }

    private int[] topK(List<List<Integer>> list, int k) {
        List<Integer> ans = new ArrayList<>();

        for(int i = list.size() - 1; i >= 0; i--) {
            List<Integer> idx = list.get(i);
            if(idx.size() == 0) {
                continue;
            } else {
                for(int num : idx) {
                    ans.add(num);
                    if(ans.size() == k) {
                        return ans.stream().mapToInt(x -> x).toArray();
                    }
                }
            }
        }

        return new int[k];
    }
}
