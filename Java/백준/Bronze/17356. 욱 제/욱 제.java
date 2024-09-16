import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int A=scan.nextInt();
        int B=scan.nextInt();

        float M=(B-A)/400f;

        System.out.println(1/(1+Math.pow(10,M)));

    }
}