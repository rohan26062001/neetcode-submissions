class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        
        int l = 0, r = s1.length();
        while(r <= s2.length()) {
            String s = s2.substring(l, r);
            if(checkAnagram(s1, s))
                return true;
            l++;
            r++;
        }

        return false;
    }

    private boolean checkAnagram(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        
        int n = s1.length();
        int[] check = new int[26];

        for(int i = 0 ; i < n; i++) {
            check[s1.charAt(i)-'a']++;
            check[s2.charAt(i)-'a']--;
        }

        for(int i = 0; i < 26; i++) {
            if(check[i] != 0)
                return false;
        }

        return true;
    }
}
