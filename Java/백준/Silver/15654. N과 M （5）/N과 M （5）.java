import java.util.*;

public class Main {
    private static int M;
    private static StringBuilder sb;
    private static String[] arr;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        sb = new StringBuilder();

        int N = scan.nextInt();
        M = scan.nextInt();

        arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scan.next();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1)-Integer.parseInt(o2);
            }
        });

        for (String s : arr) {
            ArrayList<String> arr = new ArrayList<>();
            arr.add(s);
            tracking(0, arr);
            arr.remove(s);
        }

        System.out.println(sb);

    }

    private static void tracking(int depth, ArrayList<String> before) {

        if (depth == M-1) {
            for (String s : before) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (String s : arr) {
            if (before.contains(s)) continue;
            before.add(s);

            tracking(depth+1,before);
            before.remove(s);
        }


    }

}
