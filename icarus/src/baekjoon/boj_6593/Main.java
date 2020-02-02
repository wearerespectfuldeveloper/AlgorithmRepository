package baekjoon.boj_6593;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 상범 빌딩
 * https://www.acmicpc.net/problem/6593
 */
public class Main {

    public static int EMPTY = 0;
    public static int GOLD = 1;
    public static int VISITED = 2;
    public static int START = 3;
    public static int END = 4;
    public static int[][][] building;
    public static int[][][] dist;
    public static Queue<Location> queue;
    public static int L, R, C;
    public static int[] dx = {-1, 0, 1, 0, 0, 0};
    public static int[] dy = {0, -1, 0, 1, 0, 0};
    public static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] input = br.readLine().split(" ");

            if (input[0].equals("0") && input[1].equals("0") && input[2].equals("0"))
                break;

            L = Integer.parseInt(input[0]);
            R = Integer.parseInt(input[1]);
            C = Integer.parseInt(input[2]);

            building = new int[L][R][C];
            dist = new int[L][R][C];
            Location start = null;
            Location end = null;
            queue = new LinkedList<>();

            //input..
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    char[] space = br.readLine().toCharArray();

                    for (int k = 0; k < C; k++) {
                        if (space[k] == 'S') {
                            start = new Location(k, j, i);
                            building[i][j][k] = START;
                        } else if (space[k] == 'E') {
                            end = new Location(k, j, i);
                            building[i][j][k] = EMPTY;
                        } else if (space[k] == '.') {
                            building[i][j][k] = EMPTY;
                        } else {
                            building[i][j][k] = GOLD;
                        }
                    }
                }
                br.readLine();
            }

            bw.write(bfs(start, end));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static String bfs(Location start, Location end) {
        building[start.z][start.y][start.x] = VISITED;
        queue.offer(start);            //시작점 주입
        while (!queue.isEmpty()) {
            Location current = queue.poll();

            if (current.equals(end)) {
                return "Escaped in " + dist[current.z][current.y][current.x] + " minute(s).\n";
            }

            for (int i = 0; i < 6; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int nz = current.z + dz[i];
                Location nextLocation = new Location(nx, ny, nz);

                if (nextLocation.isAvailableLocation()
                        && !nextLocation.isVisitedLocation()
                        && nextLocation.isEmptySpace()) {
                    building[nextLocation.z][nextLocation.y][nextLocation.x] = VISITED;
                    dist[nextLocation.z][nextLocation.y][nextLocation.x] =
                            dist[current.z][current.y][current.x] + 1;
                    queue.offer(nextLocation);
                }
            }
        }

        return "Trapped!\n";
    }

    static class Location {
        int x;
        int y;
        int z;

        public Location(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public boolean isAvailableLocation() {
            return (this.x >= 0 && this.x < C)
                    && (this.y >= 0 && this.y < R)
                    && (this.z >= 0 && this.z < L);
        }

        public boolean isVisitedLocation() {
            return (building[this.z][this.y][this.x] == VISITED);
        }

        public boolean isEmptySpace() {
            return (building[this.z][this.y][this.x] == EMPTY);
        }

        @Override
        public boolean equals(Object obj) {
            Location target;

            if (obj instanceof Location) {
                target = (Location) obj;

                return this.x == target.x
                        && this.y == target.y
                        && this.z == target.z;
            }

            return false;
        }
    }
}
