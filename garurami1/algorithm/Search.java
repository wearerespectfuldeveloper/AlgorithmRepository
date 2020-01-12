package algorithm;

import java.util.Scanner;

public class Search {
	static int seqSearch(int[] a, int n, int key) {
		int i = 0;
		
		while(true) {
			if(i==n)
				return -1;
			if(a[i] ==key)
				return i;
			i++;
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num = 7;
		
		int[] y = {34,21,53,64,34,25,20};
		
		System.out.print("검색할 값 : ");
		int ky = sc.nextInt();
		
		int idx = seqSearch(y, num, ky);
		
		if(idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(ky + "은(는) x[" + idx + "]에있습니다.");
	}
}
