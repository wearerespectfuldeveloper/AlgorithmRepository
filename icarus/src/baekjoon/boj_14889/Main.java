package baekjoon.boj_14889;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 스타트와 링크
 * https://www.acmicpc.net/problem/14889
 *
 */
public class Main {

    static int N;
    static int[][] S;
    static boolean[] team;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        S = new int[N + 1][N + 1];
        team = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < (N / 2) + 1; i++) {
            solve(i, 0);
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve(int start, int people) {
        if (people == (N / 2)) {
            int teamTrue = 0;
            int teamFalse = 0;

            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if (team[i] && team[j]) teamTrue += S[i][j];
                    if (!team[i] && !team[j]) teamFalse += S[i][j];
                }
            }

            ans = Math.min(ans, Math.abs(teamTrue - teamFalse));
            return;
        }

        team[start] = true;
        for (int i = start; i < N; i++) {
            solve(i + 1, people + 1);
        }
        team[start] = false;
    }
}
