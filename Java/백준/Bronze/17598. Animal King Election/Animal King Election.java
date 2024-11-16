import java.util.Scanner;

class Main{
    public static void main(String[] args){

        Scanner scan=new Scanner(System.in);

        int tiger=0;
        int lion=0;

        while(scan.hasNext()){
            if(scan.next().equals("Lion")) lion++;
            else tiger++;
        }

        System.out.println(tiger>lion?"Tiger":"Lion");

    }

}