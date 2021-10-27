package Programmers;

public class Solution_없는_숫자_더하기 {

	public static void main(String[] args) {
		int answer = solution(new int[] {1,2,3,4,6,7,8,0});
		System.out.println(answer);
	}
	
	public static int solution(int[] numbers) {
        int answer = (1+2+3+4+5+6+7+8+9+0);
        int num = 0;
        for(int i=0; i<numbers.length; i++) {
            num += numbers[i];
        }
        answer -= num;
        return answer;
    }

}
