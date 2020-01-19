package baekjoon.boj_6359;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            boolean[] prison = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; i * j <= n; j++) {
                    prison[i * j] = !prison[i * j];
                }
            }

            int ans = 0;
            for (int i = 1; i <= n ; i++) {
                if (prison[i]) ans++;
            }
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
