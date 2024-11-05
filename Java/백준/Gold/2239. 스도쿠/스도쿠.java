import java.io.*;
import java.util.*;

public class Main {

    private static final int[][] board = new int[9][9];
    private static final boolean[][] colChecker = new boolean[9][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int i = 0; i < 9; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                int num = Character.getNumericValue(c[j]);
                board[i][j] = num;
                colChecker[i][num] = true;
            }
        }

        dfs(new int[]{0, 0});

    }

    private static void dfs(int[] index) {
        int row = index[0];
        int col = index[1];

        if (row == 9) { // 모든 행을 탐색한 경우
            printBoard();
            System.exit(0);
        }

        int nextRow = (col == 8) ? row + 1 : row;
        int nextCol = (col + 1) % 9;

        if (board[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (checker(new int[]{row, col}, i)) {
                    board[row][col] = i;
                    colChecker[row][i] = true;
                    dfs(new int[]{nextRow, nextCol});
                    board[row][col] = 0;
                    colChecker[row][i] = false;
                }
            }
        } else {
            dfs(new int[]{nextRow, nextCol});
        }
    }


    private static boolean checker(int[] index, int num) {
        if (colChecker[index[0]][num]) return false;
        for (int i = 0; i < 9; i++) {
            if (board[i][index[1]] == num) return false;
        }
        return !squareChecker(index, num);
    }


    private static boolean squareChecker(int[] index, int num) {
        int sr = index[0] / 3 * 3;
        int sc = index[1] - index[1] % 3;
        for (int row = sr; row < sr + 3; row++) {
            for (int col = sc; col < sc + 3; col++) {
                if (board[row][col] == num) return true;
            }
        }
        return false;
    }

    private static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }


}
