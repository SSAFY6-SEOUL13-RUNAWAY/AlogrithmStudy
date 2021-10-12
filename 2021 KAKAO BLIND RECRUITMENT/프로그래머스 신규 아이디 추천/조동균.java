package AlgoStudy1012;

class Solution {
	
	public static void main(String[] args) {
		String answer = solution("abcdefghijklmn.p");
		System.out.println(answer);
	}
	
    public static String solution(String new_id) {
        String answer = "";
        String restricted = "~!@#$%^&*()=+[{]}:?,<>/";
        // 1. 아이디의 모든 대문자를 대응되는 소문자로 치환
        new_id = new_id.toLowerCase();

        // 2. 알파벳 소문자, 숫자, -, _, . 제외한 모든 문자 제거
        for(int i=0; i<new_id.length(); i++)  {
        	String old = String.valueOf(new_id.charAt(i));
	        if(restricted.contains(old)) continue;
	        else answer += old;
        }
        // 3. . 2번 이상 연속된 부분은 하나로 치환
        while(answer.contains("...") || answer.contains("..")) {
            if(answer.contains("...")) answer = answer.replace("...", ".");
            if(answer.contains("..")) answer = answer.replace("..", ".");
        }
        // 4. . 가 처음이나 끝에 위치한다면 제거
        if(answer.startsWith(".")) answer = answer.substring(1);
        if(answer.endsWith(".")) answer = answer.substring(0, answer.length()-1);
        
        // 5. 빈 문자열이라면 "a" 대입
        if(answer.length() == 0) answer += "a";

        // 6. 16자 이상이면, 첫 15개 문자 제외한 나머지 제거
        if(answer.length() >= 16) {
        	answer = answer.substring(0, 15);
        	if(answer.endsWith(".")) answer = answer.substring(0, answer.length() - 1);
        }

        // 7. 2자 이하라면 마지막 문자를 길이기 3이 될 때까지 반복
        if(answer.length() <= 2) {
        	while(answer.length() < 3) {
        		answer += answer.charAt(answer.length()-1);
        	}
        }
        return answer;
    }
}