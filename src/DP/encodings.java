package DP;

public class encodings {
    public static void main(String[] args) {
        printEncodings("123", "");
    }

    public static void printEncodings(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // 🟢 Single digit choice
        char first = str.charAt(0);
        if (first != '0') { // '0' alone is invalid
            int val = first - '0';
            char code = (char) ('a' + val - 1);
            printEncodings(str.substring(1), ans + code);
        }

        // 🟢 Two-digit choice
        if (str.length() >= 2) {
            int val = Integer.parseInt(str.substring(0, 2));
            if (val >= 10 && val <= 26) {
                char code = (char) ('a' + val - 1);
                printEncodings(str.substring(2), ans + code);
            }
        }
    }
}
