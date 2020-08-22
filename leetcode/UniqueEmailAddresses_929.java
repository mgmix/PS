/**
 *  https://leetcode.com/problems/unique-email-addresses/
 */

class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> list = new HashSet<>();
        
        for (String s : emails) {
            String sb = s.substring(0, s.indexOf("@"));
            String result = sb.replace(".", "") + s.substring(s.indexOf("@"));
            
            if (result.contains("+")) {
                int startIndex = result.indexOf("+");
                int endIndex = result.indexOf("@");
                sb = result.substring(startIndex, endIndex);
                result = result.replace(sb, "");
            }
            
            list.add(result);
        }
        
        return list.size();
    }
    
}