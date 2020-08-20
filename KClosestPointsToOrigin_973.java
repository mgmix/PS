/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */

// 첫번째 풀이
class Solution {
    public int[][] kClosest(int[][] points, int K) {
    
        List<Point> list = new ArrayList<>();
        int[][] value = new int[K][2];
        
        // 각 포인트 제곱 계산
        // 각 제곱 계산에 루트 씌우기
        for (int i=0; i < points.length; i++) {
            Point point = new Point(points[i][0], points[i][1]);
            point.calc();
            list.add(point);
        }
        
        // 결과 비교 및 저장
        // 소팅
        Collections.sort(list, (p1, p2) -> Double.valueOf(p1.getResult()).compareTo(Double.valueOf(p2.getResult())));
        
        // K 만큼 앞에서 짤라서 반환
        for (int i=0; i < K; i++) {
            value[i][0] = list.get(i).p;
            value[i][1] = list.get(i).q;
        }
        return value;
        
    }
}

class Point {
    
    int p;
    int q;
    double result;
    
    Point(int a, int b) {
        p = a;
        q = b;
    }
    
    public void calc() {
        result = Math.sqrt( (p*p) + (q*q)); // 생각해보니 sqrt 할 필요가 없는데..
    }
    
    public double getResult() {
        return result;
    }
    
}

// Priority Queue 이용 하여 구현
/**
 * Priority Queue 는 우선순위를 정하여 먼저 방출
 */
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        int[][] result = new int[K][2];
        
        Queue<int[]> queue = new PriorityQueue<>(
            (a,b) -> ((a[0]*a[0]) + (a[1]*a[1])) - ((b[0]*b[0]) + (b[1]*b[1]))
        );
        
        for (int[] p : points) {
            queue.offer(p);
        }
        
        for (int i=0; i < K; i++) {
            result[i] = queue.poll();
        }
        
        return result;
        
    }
}




