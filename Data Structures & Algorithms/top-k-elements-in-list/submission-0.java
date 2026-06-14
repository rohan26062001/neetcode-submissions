class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num,
                frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> bucketList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            bucketList.add(null);
        }

        for (int elem : frequencyMap.keySet()) {
            int freq = frequencyMap.get(elem);

            if (bucketList.get(freq) == null) {
                bucketList.set(freq, new ArrayList<>());
            }

            bucketList.get(freq).add(elem);
        }

        int[] result = new int[k];
        int idx = 0;

        for (int freq = n; freq >= 0 && idx < k; freq--) {
            if (bucketList.get(freq) != null) {
                for (int num : bucketList.get(freq)) {
                    result[idx++] = num;

                    if (idx == k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
