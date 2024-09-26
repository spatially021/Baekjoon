import java.io.*;
import java.util.*;

public class Main {

    private static final Stack<Integer> stack = new Stack<>();
    private static int index = 0;
    private static int[] target;
    private static int[] result;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        target = new int[N];


        for (int i = 0; i < N; i++) {
            target[i] = Integer.parseInt(br.readLine());
        }

        result = new int[N];


        for (int i = 1; i < N + 1; i++) {
            stack.push(i);
            sb.append("+\n");
            check();
        }

        System.out.println(isSame()?sb:"NO");

    }

    private static void check() {

        while (true) {
            if(stack.isEmpty()) return;
            if (stack.peek() == target[index]){
                result[index] = stack.pop();
                index++;
                sb.append("-\n");
            }else return;
        }
    }

    private static boolean isSame(){
        for(int i=0;i<target.length;i++){
            if(target[i]!=result[i]) return false;
        }

        return true;
    }


}
