package baekjoon.boj_1012;

import java.io.*;

public class Main {

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, -1, 0, 1};
    static boolean[][] map;
    static boolean[][] visited;
    static int M, N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            K = Integer.parseInt(input[2]);

            map = new boolean[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                String[] position = br.readLine().split(" ");
                int X = Integer.parseInt(position[0]);
                int Y = Integer.parseInt(position[1]);

                map[Y][X] = true;
            }

            int ans = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && map[i][j]) {
                        ans++;
                        dfs(j, i);
                    }
                }
            }

            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int x, int y) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isAvailablePos(nx, ny) && isConnected(nx, ny)) {
                dfs(nx, ny);
            }
        }
    }

    public static boolean isAvailablePos(int x, int y) {
        return (x >= 0 && y >= 0) && (x < M && y < N);
    }

    public static boolean isConnected(int x, int y) {
        return !visited[y][x] && map[y][x];
    }
}
