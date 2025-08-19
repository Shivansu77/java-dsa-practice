package DP;

public class printPathswithjumps {
    public static void main(String[] args) {
       printMazejumps(1,1,3,3,"");
    }
    public static void printMazejumps(int sr,int sc,int dr,int dc,String path){
        if(sr==dr && sc==dc){
            System.out.println(path);
        }
        if(sr>dr ||sc>dc )return;
        for(int ms=1;ms<=dc-sc;ms++){
            printMazejumps(sr,sc+ms,dr,dc,path+"H"+ms);
        }
        for(int ms=1;ms<=dr-sr;ms++){
            printMazejumps(sr+ms,sc,dr,dc,path+"V"+ms);
        }

    }
}
