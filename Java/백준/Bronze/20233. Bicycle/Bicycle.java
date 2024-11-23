import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int a = Integer.parseInt(br.readLine());
        int x = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());

        // the amount of money you would spend on the first option
        // (base price + (commute time - free time) * minute fee) * working days
        int firstOptionFee = a + ((T>30 ? T : 30)  - 30) * x * 21;

        // the amount of money you would spend on the second option
        // base price + (commute time - free time) * minute fee * working days
        int secondOptionFee = b + ((T>45 ? T : 45) - 45) * y * 21;

        System.out.print(firstOptionFee + " " + secondOptionFee);
    }
}