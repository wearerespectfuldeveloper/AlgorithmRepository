package hackerrank.modified_karprekar_numbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int p = Integer.parseInt(br.readLine());
        int q = Integer.parseInt(br.readLine());
        boolean foundFlag = false;

        while (p <= q) {
            int d = Integer.toString(p).length();
            long square = (long) p * p;
            String strSquare = Long.toString(square);

            int r = Integer.parseInt(strSquare.substring(strSquare.length() - d));
            int l = (strSquare.length() - d > 0) ?
                    Integer.parseInt(strSquare.substring(0, strSquare.length() - d)) : 0;

            if (p == (l + r)) {
                bw.write(p + " ");
                foundFlag = true;
            }

            p++;
        }

        if (!foundFlag) {
            bw.write("INVALID RANGE\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}