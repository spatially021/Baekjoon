import java.util.*;

public class Main {

    private static long B;
    private static HashMap<Long, Long> map = new HashMap<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        long A = scan.nextInt();
        B = scan.nextInt();

        bfs(A);

        System.out.println(map.getOrDefault(B,-1L));
    }


    private static void bfs(long n) {

        Queue<Long> queue = new LinkedList<>();

        queue.add(n);
        map.put(n, 1L);

        while (!queue.isEmpty()) {

            long i = queue.poll();

            long a = i * 2;
            if (a <= B) {
                queue.add(a);
                map.put(a,map.get(i)+1);
            }

            long b = i * 10 + 1;

            if (b <= B) {
                queue.add(b);
                map.put(b,map.get(i)+1);
            }
        }
    }
}
