class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap<>();

        int n = strs.length;
        for(int i = 0; i < n; i++) {
            List<Integer> arr = calculate(strs[i]);

            if(map.containsKey(arr)) {
                map.get(arr).add(strs[i]);
            } else {
                List<String> s = new ArrayList<>();
                s.add(strs[i]);
                map.put(arr, s);
            }
        }

        return new ArrayList<>(map.values());
    }

    private List<Integer> calculate(String s) {
        List<Integer> arr = new ArrayList<>(Collections.nCopies(26, 0));
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            int prevVal = arr.get(idx);
            arr.set(idx, prevVal + 1);
        }
        return arr;
    }
}
