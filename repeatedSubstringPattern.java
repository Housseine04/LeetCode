//459. Repeated Substring Pattern

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        //contains all rotations
        String allRotations = s+s;
        //remove first and last elem (trivial occurences)
        allRotations = allRotations.substring(1, allRotations.length()-1);
        return allRotations.contains(s);
    }
}