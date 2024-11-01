import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] c = br.readLine().toCharArray();

        int counter = 0;

        for (int i = 0; i < c.length; i++) {

            if (c[i] == 'c') {
                if (i + 1 < c.length) {
                    if (c[i + 1] == '=') i++;
                    else if (c[i + 1] == '-') i++;
                }
            } else if (c[i] == 'd') {
                if (i + 1 < c.length) {
                    if (c[i + 1] == 'z') {
                        if (i + 2 < c.length)
                            if (c[i + 2] == '=') i+=2;
                    } else if (c[i + 1] == '-') i++;
                }
            } else if (c[i] == 'l') {
                if (i + 1 < c.length) {
                    if (c[i + 1] == 'j') i++;
                }
            } else if (c[i] == 'n') {
                if (i + 1 < c.length) {
                    if (c[i + 1] == 'j') i++;
                }
            } else if (c[i] == 's') {
                if (i + 1 < c.length) {
                    if (c[i + 1] == '=') i++;
                }
            } else if (c[i] == 'z') {
                if (i + 1 < c.length) {
                    if (c[i + 1] == '=') i++;
                }
            }

            counter++;

        }

        System.out.println(counter);

    }
}
