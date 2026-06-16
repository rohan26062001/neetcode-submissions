class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length, maxFreq = 0;
        // element-vs-freq
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num)+1);
            }
            maxFreq = Math.max(maxFreq, map.get(num));
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= maxFreq; i++) {
    list.add(null);
}
        List<Integer> keys = new ArrayList<>(map.keySet());
        for(int key : keys) {
            int freq = map.get(key);
            if(list.get(freq) == null) {
                List<Integer> l = new ArrayList<>();
                l.add(key);
                list.set(freq, l);
            } else {
                list.get(freq).add(key);
            }
        }

        // Collect top k frequent elements
        int[] result = new int[k];
        int idx = 0;

        for (int freq = maxFreq; freq >= 0 && idx < k; freq--) {
            if (list.get(freq) != null) {
                for (int num : list.get(freq)) {
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
