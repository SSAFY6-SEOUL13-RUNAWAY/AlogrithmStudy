package Programmers;

import java.util.*;

// 테스트 1 〉	통과 (3255.84ms, 400MB) ...;;
public class Solution_단체사진_찍기 {

	// 부호 
	static String SIGN= "=<>";
    
	// permutation 용
	static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static String[] permutation;
    static boolean[] visited;
    
    // 개수 측정
    static int tot;
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] data = {"N~F=0", "R~T>2"};
		int n = 2;
		
		int answer = solution(2, data);
		System.out.println(answer);

	}
	
	public static int solution(int n, String[] data) {
        int answer = 0;
        // data[0].charAt(0) = 사람1
        // data[0].charAt(2) = 사람2
        // data[0].charAt(3) = 부등호
        // data[0].charAt(4) = 간격
        permutation = new String[8];
        visited = new boolean[8];
        tot = 0;
        perm(0, n, data);
        answer = tot;
        return answer;
    }
    
    public static void perm(int cnt, int N, String[] condition) {
        if(cnt == 8) {
            int first_person = 0;	// 첫번째 사람
            int second_person = 0;	// 두번째 사람
            int sign = 0;		// 부호
            int space = 0;		// 간격
            
            for(int i=0; i<N; i++) {
                for(int j=0; j<permutation.length; j++) {
                	// 사람 index 찾기
                    if(String.valueOf(condition[i].charAt(0)).equals(permutation[j])) first_person = j;
	                if(String.valueOf(condition[i].charAt(2)).equals(permutation[j])) second_person= j;
                }
                // sign 찾기
                sign = SIGN.indexOf(condition[i].charAt(3));
                // 간격 찾기
                space = condition[i].charAt(4) - '0';
                // sign에 따른 간격 check
                // 조건에 하나라도 틀리면 return
                if(sign == 0) {
                    if(Math.abs(first_person - second_person) != space + 1) return;
                } else if(sign == 1) {
                    if(Math.abs(first_person - second_person) >= space + 1) return;
                } else if(sign == 2) {
                    if(Math.abs(first_person - second_person) <= space + 1) return;
                } else continue;
            }
            // for문을 다돌았다는건 모든 조건이 알맞다.
            // 증가.
            tot++;
            return;
        }
        
        for(int i=0; i<8; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            permutation[cnt] = friends[i];
            perm(cnt+1, N, condition);
            visited[i] = false;
        }
    }

	
}
