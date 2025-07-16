package recursion;

public class factorial {
    public static int fact(int n){
        if(n==1)return 1;
        int fnt1=fact(n-1);
        int fn=fnt1*n;
        return fn;
    }
    public static void main(String[] args) {
        System.out.println(fact(5));
    }
}
