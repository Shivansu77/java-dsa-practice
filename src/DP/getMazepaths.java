package DP;

import java.util.ArrayList;
//finding all possible paths guys literally amazing
public class getMazepaths {
    public static void main(String[] args) {
        System.out.println(getPaths(1,1,3,3));
    }
    public static ArrayList<String> getPaths(int sr,int sc,int dr,int dc){
        if (sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");  // ✅ add empty path
            return bres;
        }
        ArrayList<String> down=new ArrayList<>();
        ArrayList<String> right=new ArrayList<>();
        if(sr<dr){
            down=getPaths(sr+1,sc,dr,dc);
        }
        if(sc<dc){
            right=getPaths(sr,sc+1,dr,dc);
        }
        ArrayList<String>paths=new ArrayList<>();
        for(String path : down){
            paths.add("V"+path);
        }
        for(String path : right){
            paths.add("H"+path);
        }

        return paths;
    }
}
