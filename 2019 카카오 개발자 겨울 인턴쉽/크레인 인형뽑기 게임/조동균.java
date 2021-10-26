package Programmers;

import java.util.*;

public class Solution_크레인_인형뽑기_게임 {

	static Stack<Integer> stack;
    
	// 테스트 4 〉	통과 (1.05ms, 76MB)
	public static void main(String[] args) {
		int[][] board = new int[][] {
			{0,0,0,0,0},
			{0,0,1,0,3},
			{0,2,5,0,1},
			{4,2,4,4,2},
			{3,5,1,3,1}
		};
		
		int[] moves = new int[] {1,5,3,5,1,2,1,4};
		
		int answer = solution(board, moves);
		System.out.println(answer);
	}
	
	public static int solution(int[][] board, int[] moves) {
        // 터진 개수
        int answer = 0;
        stack = new Stack<>();
        // moves = 1이면 
        // 00 10 20 30 40 50 검사하면서 가장 위에 있는 인형 뽑기
        // moves = 2이면
        // 01 11 21 31 41 51 검사하면서 가장 위에 있는 인형 뽑기
        for(int i=0; i<moves.length; i++) {
            // index에 알맞게 move - 1
            int num = moves[i] - 1;
            for(int j=0; j<board.length; j++) {
            // j = 행, num = 열
            if(board[j][num] == 0) continue;
                // 0이 아닐때 stack이 비어있으면
                if(stack.isEmpty()) {
                    // 넣고
                    stack.push(board[j][num]);
                }
                else {
                    // 아니면, 검사해보고 넣기
                    if(stack.peek() == board[j][num]) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(board[j][num]);
                    }
                }
                board[j][num] = 0;
                break; 
            } 
        }
        return answer;
    }

}
