package hackerrank.chocolate_feast;

import java.io.*;

public class Solution {

    // Complete the chocolateFeast function below.
    static int chocolateFeast(int n, int c, int m) {
        int ans = n / c;
        int wrappers = ans;

        while (wrappers >= m) {
            int chocolate = wrappers / m;
            ans += chocolate;
            wrappers %= m;
            wrappers += chocolate;

        }

        return ans;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] ncm = br.readLine().split(" ");

            int n = Integer.parseInt(ncm[0]);

            int c = Integer.parseInt(ncm[1]);

            int m = Integer.parseInt(ncm[2]);

            int result = chocolateFeast(n, c, m);

            bw.write(String.valueOf(result));
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
