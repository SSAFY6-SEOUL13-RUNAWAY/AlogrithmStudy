package 프로그래머스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 신규아이디추천 {

	static StringBuilder new_id;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new_id = new StringBuilder(br.readLine());
//		1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
		for (int i = 0; i < new_id.length(); i++) {
			if ((int) new_id.charAt(i) >= 65 && (int) new_id.charAt(i) <= 90)
				new_id.setCharAt(i, (char) ((int) new_id.charAt(i) + 32));
		}
		System.out.println("1단계 후: " + new_id);

//		2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
		for (int i = 0; i < new_id.length(); i++) {
			// 사용가능문자 패스
			if (checkAbleChar((int) new_id.charAt(i)))
				continue;
			// 아니면 지운다
			new_id.deleteCharAt(i);
			i--;
		}
		System.out.println("2단계 후: " + new_id);

//		// 3.new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
		for (int i = 0; i < new_id.length(); i++) {
			if (new_id.charAt(i) == '.') {
				// . 뒤부터 확인
				deleteComma(i + 1);
			}
		}
		System.out.println("3단계 후: " + new_id);

//		4단계 아이디의 처음이나 끝에 위치한 '.'가 제거되었습니다.

		if (new_id.length() != 0 && new_id.charAt(new_id.length() - 1) == '.') {
			new_id.setLength(new_id.length() - 1);
		}
		if (new_id.length() != 0 && new_id.charAt(0) == '.') {
			new_id.delete(0, 1);
		}

		System.out.println("4단계 후: " + new_id);

//		5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
		if (new_id.length() == 0)
			new_id.append("a");

		System.out.println("5단계 후: " + new_id);

//		6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//	     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
		if (new_id.length() > 15) {
			new_id.setLength(15);
			if (new_id.charAt(14) == '.')
				new_id.deleteCharAt(14);
		}
		System.out.println("6단계 후: " + new_id);

//		7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다
		while (new_id.length() < 3) {
			new_id.append(new_id.charAt(new_id.length() - 1));
		}
		
		System.out.println(new_id);
//		return new_id.toString();
	}
	
	private static void deleteComma(int i) {
		for (int j = i; j < new_id.length(); j++) {
			// 마지막 문자거나 .이 아니라면
			if (new_id.charAt(j) != '.') {
				new_id.delete(i, j);
				return;
			}
		}
		// 여기까지 안걸렸다는것은 뒤에가 전부.이라는 뜻
		new_id.setLength(i);
	}

	private static boolean checkAbleChar(int c) {
		return c == 45 || c == 46 || c == 95 || (c >= 97 && c <= 122) || (c >= 48 && c <= 57);
	}

}
