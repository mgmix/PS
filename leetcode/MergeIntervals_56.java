/**
 * Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

 */

// 1. 구조화 시킬 수 있다면 Class 로 빼기
// 2. 2d array <-> List  자유자재로 구현 할줄 알아야한다. 
// 3. Comparator 사용법 숙지

class Solution {
    public int[][] merge(int[][] intervals) {
        // 0 0  
        // 0 1
        if (intervals.length == 0) return new int[][] {};
        
        ArrayList<Interval> list = new ArrayList<>();
        ArrayList<Interval> answer = new ArrayList<>();
        
        for (int i=0; i < intervals.length; i++) {
            list.add(new Interval( intervals[i][0], intervals[i][1]));
        }
        
        Collections.sort(list, (a,b) -> a.start - b.start);
        
        Interval temp = list.get(0);
        
        for (int i= 1; i < list.size(); i++) {
            if ( temp.end >= list.get(i).start ) {
                temp.end = Math.max(temp.end, list.get(i).end);
            
            } else {
                answer.add(new Interval(temp.start,temp.end));
                temp = list.get(i);
            }
            
        }
        
        if(!answer.contains(temp)) {
                answer.add(temp);
        }
        
        
        int[][] result = new int[answer.size()][2];
        
        for (int i=0; i < answer.size(); i++) {
            result[i][0] = answer.get(i).start;
            result[i][1] = answer.get(i).end;
        }
       return result;
    }
}

class Interval {
    int start;
    int end;
    
    Interval() {
        start = 0;
        end = 0;
    }
    
    Interval(int s, int e) {
        start = s;
        end = e;
    }
}