class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        Set<Character> set = new HashSet<>(); set.add(s.charAt(0));
        int l = 0, max_len = 0;

        for(int r = 1; r < s.length(); r++) {
            while(set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            max_len = Math.max(max_len, r-l+1);
        }

        return max_len;
    }
}
