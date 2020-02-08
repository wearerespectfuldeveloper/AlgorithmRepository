package hackerrank.the_time_in_words;

import java.io.*;

public class Solution {

    static String[] numbers = {
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen",
            "twenty",
            "twenty one",
            "twenty two",
            "twenty three",
            "twenty four",
            "twenty five",
            "twenty six",
            "twenty seven",
            "twenty eight",
            "twenty nine"
    };

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        if (m == 0) {
            return numbers[h] + " o' clock";
        } else if (m < 30) {
            if (m == 1) {
                return numbers[m] + " minute past " + numbers[h];
            }
            else if (m == 15) {
                return "quarter past " + numbers[h];
            } else {
                return numbers[m] + " minutes past " + numbers[h];
            }
        } else if (m == 30) {
            return "half past " + numbers[h];
        } else {
            if (h == 12) {
                h = 0;
            }
            if (m == 59) {
                return numbers[60 - m] + " minute to " + numbers[h + 1];
            } else if (m == 45) {
                return "quarter to " + numbers[h + 1];
            } else {
                return numbers[60 - m] + " minutes to " + numbers[h + 1];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int h = Integer.parseInt(br.readLine());

        int m = Integer.parseInt(br.readLine());

        String result = timeInWords(h, m);

        bw.write(result);
        bw.newLine();

        bw.close();
        br.close();
    }
}
