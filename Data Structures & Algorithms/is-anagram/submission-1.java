class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] anagram = new int[26];
        int n = s.length();
        for(int i = 0; i < 26; i++)
            anagram[i] = 0;

        for(int i = 0; i < n; i++) {
            int idx1 = s.charAt(i) - 'a';
            int idx2 = t.charAt(i) - 'a';

            anagram[idx1] = anagram[idx1] + 1;
            anagram[idx2] = anagram[idx2] - 1;
        }

        for(int i = 0; i < 26; i++) {
            if(anagram[i] != 0)
                return false;
        }

        return true;
    }
}
