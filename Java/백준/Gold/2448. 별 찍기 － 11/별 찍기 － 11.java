import java.io.*;
import java.util.Arrays;

public class Main {
    private static char[][] stars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int N=Integer.parseInt(br.readLine());
        stars =new char[N][N*2-1];

        for(int i=0;i<N;i++){
            Arrays.fill(stars[i],' ');
        }

        recursion(0,N-1,N);

        for(char[] C:stars){
            for(char c:C){
                sb.append(c);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static void recursion(int r,int c,int N){

        if(N==3){
            stars[r][c] = '*';
            stars[r + 1][c - 1] = stars[r + 1][c + 1] = '*';
            stars[r + 2][c - 2] = stars[r + 2][c - 1] = stars[r + 2][c] = stars[r + 2][c + 1] = stars[r + 2][c + 2] = '*';
            return;
        }
        int cnt=N/2;
        recursion(r,c,cnt);
        recursion(r+cnt,c-cnt,cnt);
        recursion(r+cnt,c+cnt, cnt);

    }

}
