class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0 || n == 1)    return n;

        Set<Character> set = new HashSet<>(); set.add(s.charAt(0));
        int l = 0, maxLen = 0;
        for(int r = 1; r < n; r++) {
            while(set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
            set.add(s.charAt(r));
        }

        return maxLen;
    }
}
