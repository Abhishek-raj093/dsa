import java.util.*;

class Solution 
{
    public boolean findRotation(int[][] matrix, int[][] target) 
    {
        int len=matrix[0].length;
        int temp=0;
        for(int z=0;z<4;z++)
        {    
            temp=0;
            //transpose the grid given
            for(int k=0;k<len;k++)
            {
                for(int m=k;m<len;m++)
                {
                    temp=matrix[k][m];
                    matrix[k][m]=matrix[m][k];//interchanging rows and columns
                    matrix[m][k]=temp;
                }
        
            }   
            //now shifting elements from starting to end and end to starting in transposed grid to get rotation

            for(int k=0;k<len;k++)
            {
                for(int m=0;m<len/2;m++)
                {
                    temp=matrix[k][m];
                    matrix[k][m]=matrix[k][len-m-1];
                    matrix[k][len-m-1]=temp;
                }
            } 
            if(check(matrix,target))//if equal, return true
            return true;
        }
        return false;
    }
    public boolean check (int [][] grid, int[][] target)
    {
        int row=grid.length;
        int col=grid[0].length;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]!=target[i][j])//if even 1 element mismatch, return false
                return false;
            }
        }
        return true;
    }
}