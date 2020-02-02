package baekjoon.boj_4677;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static int PLOT = 0; //normal land
    public static int POCKET = 1;   //contains oil
    public static int VISITED = 2;
    public static int[][] map;
    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    public static int m, n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] input = br.readLine().split(" ");
            m = Integer.parseInt(input[0]);
            n = Integer.parseInt(input[1]);

            if (m == 0 || n == 0) break;

            map = new int[m][n];
            int ans = 0;
            for (int i = 0; i < m; i++) {
                char[] landInput = br.readLine().toCharArray();

                for (int j = 0; j < n; j++) {
                    if (landInput[j] == '*') {
                        map[i][j] = PLOT;
                    } else {
                        map[i][j] = POCKET;
                    }

                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isExploreLand(j, i)) {
                        explore(j, i);
                        ans++;
                    }
                }
            }

            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void explore(int x, int y) {
        map[y][x] = VISITED;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isAvailableLand(nx, ny)) {
                explore(nx, ny);
            }
        }
    }

    public static boolean isExploreLand(int x, int y) {
        return map[y][x] == POCKET;
    }

    public static boolean isAvailableLand(int x, int y) {
        return (x >= 0 && y >= 0) && (x < n && y < m) && (map[y][x] == POCKET);
    }
}
