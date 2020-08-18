/**
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.
 */

// 첫번째 풀이
class Solution {
    public int numJewelsInStones(String J, String S) {
            
        int count = 0;
        List<String> jewel = new ArrayList<>();
        List<String> stone = new ArrayList<>();
        
        for(int i=0; i < J.length(); i++) {
            jewel.add(J.substring(i, i+1));
        }
        
        for (int i=0; i < S.length(); i++) {
            for (String j : jewel) {
                if (j.equals(S.substring(i, i+1))) {
                    count++;
                }
            }
        }

        return count;
    }
}


// 중복을 제거하는게 핵심! Set 이용한 풀이
class Solution {
    public int numJewelsInStones(String J, String S) {
            
        int count = 0;
        Set<Character> jewel = new HashSet<>();
        
        
        for (char j : J.toCharArray() ) {
            jewel.add(j);
        }
        
        for (char s : S.toCharArray()) {
            if (jewel.contains(s)) count++;
        }
        
        return count;
    }
}