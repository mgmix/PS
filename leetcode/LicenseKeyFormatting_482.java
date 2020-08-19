/**
 * https://leetcode.com/problems/license-key-formatting/
 */
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        
        // 중간 문자 모두 제거, 전체 대문자 변환
        String str = S.replace("-", "");
        str = str.toUpperCase();
        
        // 4자리로 끊기, 뒤에서 부터 
        StringBuilder sb = new StringBuilder();
        
        for (char i : str.toCharArray()) {
            sb.append(i);
        }
        
        for (int i=K; i < str.length(); i=i+K) {
            sb.insert(str.length() - i,"-");
        }
                
        return sb.toString();
    }
}