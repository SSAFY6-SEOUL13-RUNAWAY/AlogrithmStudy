package programmers.level1;

public class Solution_숫자_문자열과_영단어 {

	/*
	 * 테스트 6 〉	통과 (0.50ms, 61.3MB)
	 */
	
	public static void main(String[] args) {
		String s = "one4seveneight";
		
		int num = solution(s);
		System.out.println(num);
	}
	
	public static int solution(String s) {
        String[] word = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0; i<word.length; i++) {
        	s = s.replaceAll(word[i], String.valueOf(i));        	
        }
        
        int answer = Integer.parseInt(s);
        return answer;
    }

}
