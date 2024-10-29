import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int num=scan.nextInt();
        int med,med_,med__;
        int len=0;
        int result;
        int count=0;
        for(int i=1;i<num;i++){
            med=i;
            med__=i;
            while(med__>=1){
                med__/=10;
                len++;
            }

            result=i;
            for(int j=0;j<len;j++){
              med_=med%10;
              result+=med_;
              med/=10;
            }
            if(result==num){
                System.out.println(i);
                count++;
                break;
            }
            len=0;
        }
        if(count==0) System.out.println("0");
    }
}
