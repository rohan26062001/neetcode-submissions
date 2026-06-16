class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        int n = s.length();
        int[] alph = new int[26];

        for(int i = 0; i < n; i++) {
            int chA = s.charAt(i) - 'a';
            int chB = t.charAt(i) - 'a';
            alph[chA]++;
            alph[chB]--;
        }

        for(int i = 0; i < 26; i++) {
            if(alph[i] != 0)
                return false;
        }

        return true;
    }
}
