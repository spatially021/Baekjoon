import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int aSum = 0;
        int bSum = 0;

        for (int i = 3; i >0; i--) {
            aSum += scan.nextInt()*i;
        }

        for (int i = 3; i >0; i--) {
            bSum += scan.nextInt()*i;
        }


        if (aSum == bSum) System.out.println("T");
        else System.out.println(aSum>bSum?"A":"B");


    }
}