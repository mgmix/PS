// 무작정 해결, 좋지 못한 해결법
class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        int[] result = new int[T.length];
        for (int i=0; i < T.length; i++) {
            int count = 0;
            for(int j=i+1; j < T.length; j++) {
                if(T[i] < T[j]) {
                    result[i] = count+1;
                    break;
                } else {
                   count++; 
                }
            }
        }
        return result;
    }
}

// Stack 사용 하여 해결 
class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack();
        
        for(int i=0; i < T.length; i++) {
            System.out.println(i);
            while(!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int index = stack.pop();
                System.out.println("index = " + index);
                result[index] = i - index;
                System.out.println("result = " + result[index]);
            }
            System.out.println("stack push= " + i);
            stack.push(i);
        }
        return result;
    }
}