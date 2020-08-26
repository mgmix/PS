/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * 
 *  너무 어렵다 다시풀어보기...
 */

// 첫번째 풀이 
// 문자를 ASCII 코드로 변경하여 풀기!
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        int[] pattern  = new int[128]; 
        
        // 
        for (int i=0; i < p.length(); i++) {
            pattern[p.charAt(i)]++;
        }
        
        // 
        for (int i=0; i < s.length()-p.length()+1; i++) {
            int[] list = new int[128];
            for (int j=0; j < p.length(); j++) {
                list[s.charAt(i+j)]++;  // 0 a(65) -> 1
            }
            
            if (check(list, pattern)) {
                result.add(i);
            }
            
        }
        return result;
    }
    
    // 0 0 0 1 0 0 1 0 1 
    // 0 0 1 0 1 0 1 0 1
    // * * * * * * 1 0 1
    
    boolean check(int[] s, int[] p) {
        for (int i=0; i < p.length; i++) {
            if (p[i] != s[i]) {
                return false;
            } 
        }
        return true;
    }
}

