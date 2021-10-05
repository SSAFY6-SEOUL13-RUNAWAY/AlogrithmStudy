import java.util.Scanner;

public class Main_1541_한지희 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sum = Integer.MAX_VALUE;
		String[] s = in.nextLine().split("-");
		for (int i = 0; i < s.length; i++) {
			int temp = 0;
			String[] a = s[i].split("\\+");
			for (int j = 0; j < a.length; j++) {
				temp += Integer.parseInt(a[j]);
			}
			if (sum == Integer.MAX_VALUE) {
				sum = temp;
			} else {
				sum -= temp;
			}
		}
		System.out.println(sum);
		in.close();
  }
}
