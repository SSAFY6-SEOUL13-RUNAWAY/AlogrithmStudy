import java.util.*;

class Solution {
    static int Answer;
    static Stack<Integer> stack;
    
    public int solution(int[][] board, int[] moves) {
        Answer = 0;
        stack = new Stack<Integer>();
        
        for(int i =0; i< moves.length; i++) {
            int c = moves[i]-1;
            // 아무것도 안 뽑힐 경우
            int doll = pick(board, c);
            if(doll == 0) continue;
            
            // 뽑았으면 
            if(stack.empty()) stack.push(doll);
            else {
                // 마지막 칸과 같으면
                if(stack.peek() == doll) {
                    Answer += 2;
                    stack.pop();
                }
                else {
                    stack.push(doll);
                }
            }
        }
        
        return Answer;
    }
    
    public static int pick(int[][] board, int c) {
        for(int i = 0; i < board.length; i++) {
            if(board[i][c] != 0) {
                int temp = board[i][c]; 
                board[i][c] = 0;
                return temp;
            }
        }
        return 0;
    }
}