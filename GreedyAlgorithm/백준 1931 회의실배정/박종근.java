package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ1931회의실배정 {
	static int N;
	static ArrayList<Meeting> MeetingList;
	static StringTokenizer st;

	static class Meeting {
		int s;
		int e;

		public Meeting(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		MeetingList = new ArrayList<Meeting>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			MeetingList.add(new Meeting(s, e));
		}
		
		Collections.sort(MeetingList, new Comparator<Meeting>() {

			@Override
			public int compare(Meeting o1, Meeting o2) {
				if(o1.e != o2.e) return o1.e-o2.e;
				else return o1.s-o2.s;
			}
		});
		
		int E = 0;
		int cnt = 0;
		while (true) {
			boolean flag = true;
			for (int i = 0; i < MeetingList.size(); i++) {
				if (MeetingList.get(i).s >= E) {
					E = MeetingList.get(i).e;
					MeetingList.remove(i);
					cnt++;
					flag = false;
					continue;
				}
			}
			if (flag)
				break;
		}

		System.out.println(cnt);
	}

}
