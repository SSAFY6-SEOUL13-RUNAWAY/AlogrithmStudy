package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ17413단어뒤집기2 {
	static Boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringBuilder answer = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		flag = false;
		
		for (int i = 0; i < line.length(); i++) {
			char C = line.charAt(i);
			// 1. 스텍에 넣는다.
			stack.push(C);

			// 공백을 만났다면 
			if (!stack.isEmpty() && C == ' ') {
				// 괄호안이라서 그냥 그대로 출력
				if(flag) {
					for (int n = 0; n < stack.size(); n++) {
						answer.append(stack.get(n));
					}
					stack.clear();
				}
				//괄호 밖이라서 거꾸로 출력
				else {
					stack.pop(); // 공백 뺴고
					while (!stack.isEmpty())
						answer.append(stack.pop());
					answer.append(' ');
				}
				continue;
			}

			// 괄호 끝을 만났다면 현재까지 들어있는 스텍을 정향으로 뽑아서 정답에 넣는다.
			if (!stack.isEmpty() && C == '>') {
				stack.pop();
				for (int j = 0; j < stack.size(); j++) {
					answer.append(stack.get(j));
				}
				// 비워준다
				stack.clear();
				answer.append('>');
				flag = false;
				continue;
			}

			// 괄호 시작을 만났다면 현재까지 들어있는 스텍을 거꾸로 뽑아서 정답에 넣는다.
			if (!stack.isEmpty() && C == '<') {
				stack.pop(); // 괄호 뺴주고
				// 다시 넣어주고
				while (!stack.isEmpty())
					answer.append(stack.pop());
				answer.append('<');
				flag = true;
				continue;
			}
		}

		// 괄호를 하나도 안만났으면 전부 거꾸로 출력
		while (!stack.isEmpty())
			answer.append(stack.pop());

		System.out.println(answer);

	}
}
