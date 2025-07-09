package arc2;

import java.util.ArrayList;
import java.util.Arrays;

public class MAZE {
    static int count(int r,int c){
        if(r==1 || c==1){
            return 1;
        }
        int left=count(r-1,c);
        int right=count(r,c-1);
        return left+right;
    }
    public static void main(String[] args) {
       System.out.println(count(3,3));
       System.out.println(pathRet("",3,3));
       System.out.println(pathRetDiagonal("",3,3));
       boolean[][] maze={
               {true,true,true},
               {true,false,true},
               {true,true,true}
       };
       //pathRestriction("",maze,0,0);

        boolean[][] board={
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        //allPath("",board,0,0);
        int [][]path=new int[board.length][board[0].length];
        allPathPrint("",board,0,0,path,1);
    }
    public static void path(String p,int r,int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
        if(r>1){
            path(p+"D",r-1,c);
        }
        if(c>1){
            path(p+"R",r,c-1);
        }
    }
    public static ArrayList<String> pathRet(String p,int r,int c){
        if(r==1 && c==1){
           ArrayList<String> list=new ArrayList<>();
           list.add(p);
           return list;
        }
        ArrayList<String> list=new ArrayList<>();
        if(r>1){
            list.addAll(pathRet(p+"D",r-1,c));
        }
        if(c>1){
            list.addAll(pathRet(p+"R",r,c-1));
        }
        return list;
    }
    public static ArrayList<String> pathRetDiagonal(String p,int r,int c){
        if(r==1 && c==1){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list=new ArrayList<>();
        if(r>1 && c>1){
            list.addAll(pathRetDiagonal(p+"D",r-1,c-1));
        }
        if(r>1){
            list.addAll(pathRetDiagonal(p+"V",r-1,c));
        }
        if(c>1){
            list.addAll(pathRetDiagonal(p+"H",r,c-1));
        }
        return list;
    }
    public static void pathRestriction(String p,boolean [][] maze,int r,int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if(r<maze.length-1){
            pathRestriction(p+"D",maze,r+1,c);
        }
        if(c<maze[0].length-1){
            pathRestriction(p+"R",maze,r,c+1);
        }

    }
    public static void allPath(String p,boolean[][]maze,int r,int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c]=false;
        if(r<maze.length-1){
            allPath(p+"D",maze,r+1,c);
        }
        if(c<maze[0].length-1){
            allPath(p+"R",maze,r,c+1);
        }
        if(r>0){
            allPath(p+"U",maze,r-1,c);
        }
        if(c>0){
            allPath(p+"L",maze,r,c-1);
        }
        maze[r][c]=true;
    }
    public static void allPathPrint(String p,boolean[][]maze,int r,int c,int [][]path,int step){
        if(r==maze.length-1 && c==maze[0].length-1){
            path[r][c]=step;
           for(int []arr:path){
               System.out.println(Arrays.toString(arr));
           }
           System.out.println(p);
           System.out.println();
           return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c]=false;
        path[r][c]=step;
        if(r<maze.length-1){
            allPathPrint(p+"D",maze,r+1,c,path,step+1);
        }
        if(c<maze[0].length-1){
            allPathPrint(p+"R",maze,r,c+1,path,step+1);
        }
        if(r>0){
            allPathPrint(p+"U",maze,r-1,c,path,step+1);
        }
        if(c>0){
            allPathPrint(p+"L",maze,r,c-1,path,step+1);
        }
        maze[r][c]=true;
        path[r][c]=0;
    }


}