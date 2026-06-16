class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap<>();

        for(String str : strs) {
            List<Integer> list = calculateAnagramArray(str);
            map.computeIfAbsent(list, (k) -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private List<Integer> calculateAnagramArray(String s) {
        List<Integer> list = new ArrayList<>(Collections.nCopies(26, 0));
        for(int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            list.set(ch, list.get(ch)+1);
        }
        return list;
    }
}
