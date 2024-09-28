import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int count= scan.nextInt();
        int[][] a=new int[count][2];
        for(int i=0;i<count;i++){
            a[i][0]=scan.nextInt();
            a[i][1]=scan.nextInt();
        }
        int[] rank=new int[count];
        for(int i=0;i<count;i++){
            for(int j=0;j<count;j++){
                if(i==j) continue;
                if(a[i][0]<a[j][0]&&a[i][1]<a[j][1])rank[i]++;
            }
        }
        for(int i=0;i<count;i++){
            rank[i]++;
            System.out.print(rank[i]+" ");
        }

    }
}
