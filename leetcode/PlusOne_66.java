/**
 *  https://leetcode.com/problems/plus-one/
 */
// 첫번째 풀이
class Solution {
    public int[] plusOne(int[] digits) {

        boolean next = false;
        List<Integer> list = new ArrayList<>();
        
        for(int i= digits.length-1; i >= 0; i--) {
            if (i == digits.length-1) {
                int lastArray = digits[i];
                lastArray++;
                if (lastArray > 9) {
                    lastArray = 0;
                    next = true;
                } else {
                    next = false;
                }
                
                list.add(lastArray);
                
            } else {
                
                int value = digits[i];
                
                if (next) {
                    
                    value++;
                    
                    if (value > 9) {
                        value = 0;
                        next = true;
                    } else {
                        next = false;
                    }
                    
                }
                
                list.add(value);
                
            }
        }
        
        if (next) list.add(1);
        Collections.reverse(list);
        
        int[] result = new int[list.size()];
        for (int i=0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}

// 두번째 풀이

class Solution {
    public int[] plusOne(int[] digits) {
            
        for (int i = digits.length -1; i >= 0; i--) {

            if (digits[i] != 9) {
                digits[i]++;
                break; // 끝에가 9가 아니라면 더이상 진행 할 필요가 없음
            } else {
                digits[i] = 0;
            }
        }
        
        if (digits[0] == 0) {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
            
        }
        
        return digits;
    }
}

/**
 *  끝에 9가 있다면, 계속 더하고 맨 앞이 0이라면, 1을 앞에 붙여주면 됨
 * 
 */