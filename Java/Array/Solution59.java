package Array;


class Solution59 {
    public int[][] generateMatrix(int n) {
        int count = 1;
        int round = 0;
        int start = 0;
        int row = 0;
        int column = 0;
        int[][] result = new int[n][n];
        while(round++ < n / 2){
            for(column = start; column < n - round; column++){
                result[start][column] = count++;
            }
            for(row = start; row < n - round; row++){
                result[row][column] = count++;
            }
            for(; column >= round; column--){
                result[row][column] = count++;
            }
            for(; row >= round; row--){
                result[row][column] = count++;
            }
            start++;

        }
        if(n % 2 == 1){
            result[start][start] = count;
        }
        return result;
    }
}