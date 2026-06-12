class Solution {
    public boolean checkInclusion(String s1, String s2) {
        for(int i = 0; i < s2.length(); i++) {
            for(int j = i; j <= s2.length(); j++) {
                if(checkPermutation(s1, s2.substring(i, j)))
                    return true;
            }
        }
        return false;
    }

    private boolean checkPermutation(String s1, String s2) {
        return s1.length() == s2.length() && sortString(s1).equals(sortString(s2));
    }

    private String sortString(String input) {
        char[] charArray = input.toCharArray();
        
        // 2. Sort the array in-place
        Arrays.sort(charArray);
        
        // 3. Convert back to a String
        return new String(charArray);
    }
}
