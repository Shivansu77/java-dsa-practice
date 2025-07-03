package hashMapsForTrees;
import java.util.*;
public class fst {
    public static void main(String[] args) {
       HashMap<String,Integer> map=new HashMap<>();
       map.put("kunal",89);
        map.put("karan",99);
        map.put("Rahul",94);
        System.out.println(map);
        //System.out.println(map.get("karan "));
        //System.out.println(map.getOrDefault("Apoorva",71));
        System.out.println(map.containsKey("karan"));
        HashSet<Integer> set=new HashSet<>();
        set.add(89);
        set.add(94);
        set.add(93);
        set.add(89);
        set.add(92);
        System.out.println(set);
    }
}
