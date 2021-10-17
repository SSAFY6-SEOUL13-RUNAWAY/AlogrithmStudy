import java.util.*;

class Solution {
    static Map<String, String> Map = new HashMap<String, String>();
	static ArrayList<String> answer = new ArrayList<String>();
    
    public String[] solution(String[] record) {
        // 명령어 확인
        for(int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]," ");
            
            String cmd = st.nextToken();
            
            if(cmd.equals("Leave")) continue;
            
            String id = st.nextToken();
            String nick = st.nextToken();
            
            // 1. Enter일 경우 아이디와 닉네임을 Map에 저장한다
            // 2. 이미 아이디가 Map이 있을경우 닉네임을 바꾼다.
            Map.put(id,nick);    
        }
       
        // 4. 전체 record를 다시 돌면서 해당 명령과 닉네임을 출력한다.
        for(int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]," ");

            String cmd = st.nextToken();
            if(cmd.equals("Change")) continue;

            String id = st.nextToken();
            String korean = "";
            if(cmd.equals("Leave")) {
                korean = "님이 나갔습니다.";
            }
            else if(cmd.equals("Enter")) {
                korean = "님이 들어왔습니다.";
            }
            answer.add(Map.get(id)+korean); 
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}