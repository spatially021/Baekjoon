import java.util.*;

class Main{
    public static void main(String[] args){
        
        Scanner scan=new Scanner(System.in);
        
        int num=scan.nextInt();
        int cnt=scan.nextInt();
        
        int[] arr=new int[num];
        
        for(int i=0;i<num;i++){
            arr[i]=i+1;
        }
        
        for(int n=0;n<cnt;n++){
            
            int a=scan.nextInt();
            int b=scan.nextInt();
            
            int temp=arr[b-1];
            arr[b-1]=arr[a-1];
            arr[a-1]=temp;
        }
        
        StringBuilder sb=new StringBuilder();
        
        for(int i:arr){
            sb.append(i).append(" ");
        }
        
        System.out.println(sb);
        
    }
}