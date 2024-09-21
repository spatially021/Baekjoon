import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number=Integer.parseInt(br.readLine());

        System.out.println(number/10000==555?"YES":"NO");

    }
}