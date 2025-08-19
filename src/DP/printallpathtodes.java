package DP;

public class printallpathtodes {
    public static void main(String[] args) {
        path(1,1,3,3,"");
    }
    public static void path(int sr,int sc,int dr,int dc,String path){
        if(sr==dr && sc==dc){
            System.out.println(path);
            return ;
        }
        if(sr>dr || sc>dc)return ;
        path(sr+1,sc,dr,dc,path+"V");
        path(sr,sc+1,dr,dc,path+"H");

    }
}
