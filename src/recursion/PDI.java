public class PDI {
    public static void pdi(int n){
        if(n == 0) return;

        System.out.println(n);  // Print decreasing
        pdi(n - 1);             // Recursive call
        System.out.println(n);  // Print increasing
    }

    public static void main(String[] args) {
        pdi(5);
    }
}
