package baekjoon.boj_5567;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int n;
    public static int m;
    public static List<Integer>[] adjList;
    public static boolean[] isVisited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        adjList = new ArrayList[n + 1];
        isVisited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            adjList[a].add(b);
            adjList[b].add(a);
        }

        int ans = 0;
        isVisited[1] = true;

        for (Integer i : adjList[1]) {
            if (!isVisited[i]) {
                ans++;
                isVisited[i] = true;
            }

            for (Integer j : adjList[i]) {
                if (!isVisited[j]) {
                    ans++;
                    isVisited[j] = true;
                }
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
