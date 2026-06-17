class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.equals(s2))   return true;

        int n1 = s1.length();
        int l = 0, r = n1-1;
        while(r < s2.length()) {
            String substr = s2.substring(l, r+1);
            System.out.println(substr);
            if(isAnagram(s1, substr))
                return true;
            l++;
            r++;
        }

        return false;
    }

    private boolean isAnagram(String s, String t) {
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
