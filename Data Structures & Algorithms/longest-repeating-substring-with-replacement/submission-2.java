class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0, l = 0;
        Map<String, Integer> map = new HashMap<>();

        for(int r = 0; r < s.length(); r++) {
            String ch = String.valueOf(s.charAt(r));
            map.put(ch, map.getOrDefault(ch, 0)+1);
            while(r-l+1 - mostFrequency(map) > k){
                map.put(String.valueOf(s.charAt(l)), map.get(String.valueOf(s.charAt(l))) - 1);
                l++;
            }
            res = Math.max(res, r-l+1);
        }

        return res;
    }

    private int mostFrequency(Map<String, Integer> map) {
        List<Integer> freq = new ArrayList<>(map.values());
        
        int maxFreq = 0;
        for(int i = 0; i < freq.size(); i++) {
            maxFreq = Math.max(maxFreq, freq.get(i));
        }

        return maxFreq;
    }
}
