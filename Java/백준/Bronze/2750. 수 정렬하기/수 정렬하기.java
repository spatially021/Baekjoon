import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int count=scan.nextInt();
        int[] a=new int[count];

        for(int i=0;i<count;i++){
            a[i]= scan.nextInt();
        }

        Arrays.sort(a);
        for(int i=0;i<count;i++) {
            System.out.println(a[i]);
        }
    }
}
