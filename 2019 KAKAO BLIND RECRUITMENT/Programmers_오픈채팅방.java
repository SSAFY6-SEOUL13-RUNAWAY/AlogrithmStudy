package AlgoStudy1019;

import java.util.*;

public class Programmers_오픈채팅방 {
	
	static Map<String, String> userid = new HashMap<>();
    static Queue<String> que = new LinkedList<>();
	
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] answer = solution(record);
		System.out.println(Arrays.toString(answer));
	}
	
    public static String[] solution(String[] record) {
        String[] answer = {};
        // Enter랑 Leave 몇 개 들어왔는지 체크하는 cnt
        int cnt = 0; 
        
        for(int i=0; i<record.length; i++) {
        	// Enter, uid1234, Muzi 모양으로 분리
            String[] s = record[i].split(" ");
            // Change는 cnt++ 안해주기
            if(s[0].equals("Change")) {
                userid.put(s[1], s[2]);
                que.add(s[0]+" "+s[1]);
            } else if(s[0].equals("Leave")) {
            	// Leave는 Leave, uid1234 로 구성되어 있음.
                que.add(s[0]+" "+s[1]);
                cnt++;
            } else {
            	// Enter는 cnt++까지 해주기
                userid.put(s[1], s[2]);
                que.add(s[0]+" "+s[1]);
                cnt++;
            }
        }

        answer = makeResult(cnt);
        return answer;
    }

    public static String[] makeResult(int cnt) {
        String[] result = new String[cnt];
        // 배열 index용
        int count = 0;
        while(!que.isEmpty()) {
        	// cur = {"Enter", "uid1234"} 형태
            String[] cur = que.poll().split(" ");

            if(cur[0].equals("Enter")) {
            	result[count++] = userid.get(cur[1])+"님이 들어왔습니다.";
            } 
            else if(cur[0].equals("Leave")) {
            	result[count++] = userid.get(cur[1])+"님이 나갔습니다.";
            } 
            else continue;
        }
        
        return result;
    }
}
