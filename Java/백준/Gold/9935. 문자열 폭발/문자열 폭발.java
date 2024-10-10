import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String target = br.readLine();
        int targetLen = target.length();

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            sb.append(c);

            if (sb.length() >= targetLen && sb.substring(sb.length() - targetLen).equals(target)) {
                sb.delete(sb.length() - targetLen, sb.length());
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}
