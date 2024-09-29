import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        s1 += '?';
        s2 += '?';

        boolean[] ans = new boolean[128];
        int iter1 = 0, iter2 = 0;
        int s1len = s1.length(), s2len = s2.length();

        while (iter1 < s1len) {
            char c = s1.charAt(iter1);
            int cnt1 = 0, cnt2 = 0;

            while (iter1 < s1len && s1.charAt(iter1) == c) {
                iter1++;
                cnt1++;
            }
            while (iter2 < s2len && s2.charAt(iter2) == c) {
                iter2++;
                cnt2++;
            }
            if (cnt1 != cnt2) {
                ans[c] = true;
            }
        }

        for (char i = 0; i < 127; i++) {
            if (ans[i]) {
                System.out.print(i);
            }
        }

        scanner.close();
    }
}
