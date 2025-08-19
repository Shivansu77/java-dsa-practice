package DP;

public class permutations {
    public static void main(String[] args) {
        permutations("", "abc");
    }

    public static void permutations(String p, String up) {
        if (up.length() == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 0; i < up.length(); i++) {
            char ch = up.charAt(i);
            String left = up.substring(0, i);
            String right = up.substring(i + 1);
            String remaining = left + right;

            permutations(p + ch, remaining);
        }
    }
}
