import java.util.*;

class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n =grid.length; 
        int m = grid[0].length;
        int[][] sumx=new int[n][m];
        int[][] sumy = new int[n][m];
        char ch = grid[0][0];
        if(ch=='X'){
            sumx[0][0]=1;
        }
        if(ch=='Y')sumy[0][0]=1;
        for(int i=1; i<m; i++){
            char ch1 = grid[0][i];
            int x = sumx[0][i-1];
            int y = sumy[0][i-1];
            if(ch1=='X')x++;
            if(ch1=='Y')y++;
            sumx[0][i]=x;
            sumy[0][i]=y;
        }
        for(int i=1; i<n; i++){
            char ch1 = grid[i][0];
            int x = sumx[i-1][0];
            int y = sumy[i-1][0];
            if(ch1=='X')x++;
            if(ch1=='Y')y++;
            sumx[i][0]=x;
            sumy[i][0]=y;

        }
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                sumx[i][j]=sumx[i-1][j]+sumx[i][j-1]-sumx[i-1][j-1];
                sumy[i][j]=sumy[i-1][j]+sumy[i][j-1]-sumy[i-1][j-1];
                if(grid[i][j]=='X')sumx[i][j]++;
                if(grid[i][j]=='Y')sumy[i][j]++;
            }
        }
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(sumx[i][j]>0 && sumx[i][j]==sumy[i][j])count++;
            }
        }
        return count;
    }
}