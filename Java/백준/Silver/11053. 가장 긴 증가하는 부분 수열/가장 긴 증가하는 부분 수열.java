import java.util.*;

public class Main {

    private static int[] dp;
    private static int[] arr;

    private static int N;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        N=scan.nextInt();

        arr=new int[N];

        dp=new int[N];

        for(int i=0;i<N;i++){
            int num=scan.nextInt();
            arr[i]= num;

        }

        for(int i=0;i<N;i++){
            LTS(i);
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());



    }

    private static int LTS(int index){

        if(dp[index]==0){
            dp[index]=1;

            for(int i=index-1;i>=0;i--){
                if(arr[i]<arr[index]){
                    dp[index]=Math.max(dp[index],LTS(i)+1);
                }
            }

        }

        return dp[index];

    }

}
