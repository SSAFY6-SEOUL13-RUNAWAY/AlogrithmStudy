import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_1931_한지희 {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[][] = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return Integer.compare(o1[0], o2[0]);
				}
				return Integer.compare(o1[1], o2[1]);
			}
		});

		int end = -1;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (end <= arr[i][0]) {
				cnt++;
				end = arr[i][1];
			}
		}
		System.out.println(cnt);
		in.close();
	}
}
