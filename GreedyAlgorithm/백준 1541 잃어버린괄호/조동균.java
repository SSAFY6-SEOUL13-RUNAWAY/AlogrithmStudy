package algoStudy1001;

import java.io.*;
import java.util.*;

public class Main_1541_조동균 {

	static Stack<String> stack;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int answer = Integer.MAX_VALUE;
		String[] s = br.readLine().split("-");
		
		for(int i=0; i<s.length; i++) {
			int num = 0;
			
			String[] c = s[i].split("\\+");
			
			for(int j=0; j<c.length; j++) {
				num += Integer.parseInt(c[j]);
			}
			
			if(answer == Integer.MAX_VALUE) {
				answer = num;
			} else {
				answer -= num;
			}
		}
		
		System.out.println(answer);

	}

}
