import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Toy[] toys = new Toy[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int joy = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            toys[i] = new Toy(price, joy / (float) price, i + 1);
        }

        ArrayList<Toy> arr = new ArrayList<>(List.of(toys));

        arr.sort((o1, o2) -> Float.compare(o2.happyFrugal,o1.happyFrugal));

        int sum = 0;

        for (int i = 0; i < 3; i++) {
            sum += arr.get(i).price;
            sb.append(arr.get(i).index).append("\n");
        }

        System.out.println(sum + "\n" + sb);

    }

    private static class Toy {
        final int price;
        final float happyFrugal;
        final int index;

        private Toy(int price, float happyFrugal, int index) {
            this.price = price;
            this.happyFrugal = happyFrugal;
            this.index = index;
        }
    }

}
