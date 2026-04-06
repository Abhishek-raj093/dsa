import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for(int i=0;i<obstacles.length;i++){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(obstacles[i][0]);
            list.add(obstacles[i][1]);

            if(!set.contains(list)){
                set.add(list);
            }
        }
        int nx = 0;
        int ny = 0;
        int dir = 0;
        int ans = 0;
        for(int i=0;i<commands.length;i++){
            int c = commands[i];
            if(dir==0 && c==-1){
                dir=1;
            }
            else if(dir==0 && c==-2){
                dir = 2;
            }
            else if(dir==1 && c==-1){
                dir=3;
            }
            else if(dir==1 && c==-2){
                dir = 0;
            }
            else if(dir==2 && c==-1){
                dir=0;
            }
            else if(dir==2 && c==-2){
                dir = 3;
            }
            else if(dir==3 && c==-1){
                dir=2;
            }
            else if(dir==3 && c==-2){
                dir = 1;
            }
            else{
                if(dir==0){
                    while(c>0){
                        ArrayList<Integer> list1 = new ArrayList<>();
                        ny++;
                        c--;
                        list1.add(nx);
                        list1.add(ny);
                        if(set.contains(list1)){
                            ny--;
                            break;
                        }
                    }
                }
                else if(dir==1){
                    while(c>0){
                        ArrayList<Integer> list1 = new ArrayList<>();
                        nx++;
                        c--;
                        list1.add(nx);
                        list1.add(ny);
                        if(set.contains(list1)){
                            nx--;
                            break;
                        }
                    }
                }
                else if(dir==2){
                    while(c>0){
                        ArrayList<Integer> list1 = new ArrayList<>();
                        nx--;
                        c--;
                        list1.add(nx);
                        list1.add(ny);
                        if(set.contains(list1)){
                            nx++;
                            break;
                        }
                    }
                }
                else{
                    while(c>0){
                        ArrayList<Integer> list1 = new ArrayList<>();
                        ny--;
                        c--;
                        list1.add(nx);
                        list1.add(ny);
                        if(set.contains(list1)){
                            ny++;
                            break;
                        }
                    }
                }
                ans = Math.max(ans,(nx*nx)+(ny*ny));
            }
        }
        return ans;
    }
}