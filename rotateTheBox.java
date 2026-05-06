class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int  n = boxGrid.length;
        int m = boxGrid[0].length;

        for(int i=0; i<n; i++){
            int empty = m - 1;
            for(int j=m-1; j>=0; j--){
                if(boxGrid[i][j] =='*'){
                    empty = j - 1;
                }else if(boxGrid[i][j] == '#'){
                    boxGrid[i][j] = '.';
                    boxGrid[i][empty] = '#';
                    empty--;
                }
            }
        }

        char[][] result = new char[m][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                result[j][n-i-1] = boxGrid[i][j];
            }
        }

        return result;
    }
}