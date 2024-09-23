import java.io.*;
import java.util.*;

public class Main {

    private static int N;/*save how many layer of input line*/
    private static int[][] matrix;/*var of saving input data*/
    private static int[][] dpMax;/*var for dp data saving about max value */
    private static int[][] dpMin;/*var for dp data saving about min value*/

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());

        matrix=new int[N][3];
        dpMax =new int[N][3];
        dpMin=new int[N][3];

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<3;j++){
                matrix[i][j]=Integer.parseInt(st.nextToken());
                if(i==0){
                    dpMax[i][j]=matrix[i][j];
                    dpMin[i][j]=matrix[i][j];
                }
            }
        }/*input data*/

        for(int i=1;i<N;i++){
            for(int j=0;j<3;j++){
                if(j==1){
                    dpMax[i][j]=Math.max(Math.max(dpMax[i-1][0], dpMax[i-1][1]), dpMax[i-1][2])+matrix[i][j];
                    dpMin[i][j]=Math.min(Math.min(dpMin[i-1][0], dpMin[i-1][1]), dpMin[i-1][2])+matrix[i][j];
                }else if(j==0){
                    dpMax[i][j]=Math.max(dpMax[i-1][0], dpMax[i-1][1])+matrix[i][j];
                    dpMin[i][j]=Math.min(dpMin[i-1][0], dpMin[i-1][1])+matrix[i][j];
                }else{
                    dpMax[i][j]=Math.max(dpMax[i-1][2], dpMax[i-1][1])+matrix[i][j];
                    dpMin[i][j]=Math.min(dpMin[i-1][2], dpMin[i-1][1])+matrix[i][j];
                }
            }
        }/*dynamic programing process to bottom-down*/

        System.out.printf("%d %d",Arrays.stream(dpMax[N-1]).max().getAsInt(),Arrays.stream(dpMin[N-1]).min().getAsInt());

    }
}
