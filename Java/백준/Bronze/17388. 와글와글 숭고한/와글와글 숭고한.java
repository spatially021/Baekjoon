import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        int sum=0;

        int min=Integer.MAX_VALUE;
        int minIndex=-1;


        for(int i=0;i<3;i++){
            int input=scan.nextInt();
            sum+=input;
            if(input<min){
                min=input;
                minIndex=i;
            }
        }

        if(sum>=100) System.out.println("OK");
        else{
            if(minIndex==0)System.out.println("Soongsil");
            else if(minIndex==1) System.out.println("Korea");
            else System.out.println("Hanyang");


        }

    }
}