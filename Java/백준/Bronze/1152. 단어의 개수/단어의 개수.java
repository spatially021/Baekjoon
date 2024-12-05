import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int counter=0;
        while (scan.hasNext()) {
            scan.next();
            counter++;
        }
        System.out.println(counter);

        scan.close();
    }
}