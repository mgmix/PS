/**
 *  https://leetcode.com/problems/spiral-matrix/
 */

 // 첫번째 풀이
 // 지금 봐도 진짜 답답하게 풀었다... 어휴
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;
        // Row Col
        int rowStart = 0;
        int rowEnd = matrix.length-1;
        int colStart = 0;
        int colEnd = matrix[0].length-1;

        int size = matrix.length * matrix[0].length;
        
        while(result.size() < size) {
        // ->
        for (int i=colStart; i < colEnd+1; i++) {
            result.add(matrix[rowStart][i]);
            System.out.println("->" + matrix[rowStart][i]);
        }
        rowStart++;
            
        if (result.size() == size) break;
        
        // v
        for (int i=rowStart; i < rowEnd+1; i++) {
            result.add(matrix[i][colEnd]);
            System.out.println("v" + matrix[i][colEnd]);
        }
        colEnd--;
        
        // <-
        for (int i=colEnd; colStart <= i; i--) {
            result.add(matrix[rowEnd][i]);
        }
        rowEnd--;
            
        if (result.size() == size) break;
        
        // ^
        for (int i=rowEnd; rowStart <= i; i--) {
            result.add(matrix[i][colStart]);
            System.out.println("^" + matrix[i][colStart]);
        }
        colStart++;
            
            
        System.out.println("result" + result);
        }
        
        // 00 01 02 03 
        // 10 11 12 13
        // 20 21 22 23
            
        return result;
    }
}

// 두번째 풀이
// 조건식을 Row 와 Colum 의 크기로 설정
// row 와 colum 이 줄어들기때문에 조건문 지정 
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;
        
        int rowStart = 0;
        int rowEnd = matrix.length-1;
        int colStart = 0;
        int colEnd = matrix[0].length-1;
        
        while(rowStart <= rowEnd && colStart <= colEnd) {
            
        // Right
        for (int i=colStart; i <= colEnd; i++) {
            result.add(matrix[rowStart][i]);
        }
        rowStart++;
                    
        // Down
        for (int i=rowStart; i <= rowEnd; i++) {
            result.add(matrix[i][colEnd]);
        }
        colEnd--;
        
        // Left
        if (rowStart <= rowEnd)
        for (int i=colEnd; colStart <= i; i--) {
            result.add(matrix[rowEnd][i]);
        }
        rowEnd--;
        
        
        // Up
        if (colStart <= colEnd)
        for (int i=rowEnd; rowStart <= i; i--) {
            result.add(matrix[i][colStart]);
        }
        colStart++;
            
        }
        
        // 00 01 02 03 
        // 10 11 12 13
        // 20 21 22 23
            
        return result;
    }
}