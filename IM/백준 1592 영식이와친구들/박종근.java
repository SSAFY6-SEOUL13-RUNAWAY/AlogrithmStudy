package IM;

import java.util.HashMap;
import java.util.Scanner;

public class BJ1592영식이와친구들 {
	static int N, M ,L;
	static HashMap<Integer, Integer> hm;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		hm = new HashMap<>();
		// 편의상 1번을 0으로 바꾼다.
		int index = 0;
		int count = 0;
		
		// 1번은 1번 받은걸로 시작한다.
		hm.put(index, 1);
		
		while(true) {
			//받은 사람의 횟수 확인
			if(hm.get(index) == M) break;
			// 아니면 인덱스를 바꾼다
			// 던지는 사람 현재 받은 회수 확인
			// 홀수면 
			if(hm.get(index)%2 == 1) {
				index = (index+L)%N;
			} 
			else {
				index = (index+N-L)%N;
			}
			
			if(hm.get(index)== null) {
				hm.put(index, 1);
			}
			else hm.put(index,hm.get(index)+1); 
			count++;
		}
		
		System.out.println(count);
	}
}
