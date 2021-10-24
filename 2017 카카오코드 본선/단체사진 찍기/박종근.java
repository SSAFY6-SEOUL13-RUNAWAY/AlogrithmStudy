class Solution {
    static int Answer;
    static char[] Person = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean[] Checked;
    static char[] Line;
    
    public int solution(int n, String[] data) {
        Answer = 0;
        Checked = new boolean[8];
        Line = new char[8];

        Perm(0,data);
        return Answer;
    }
    
    public static int getLength(char start, char end) {
        int sIdx = 0;
        int eIdx = 0;
        for(int j = 0; j < 8; j++) {
            if(Line[j] == start) sIdx = j;
            else if(Line[j] == end) eIdx = j;
        }
        return Math.abs(sIdx-eIdx)-1;
    }
    
    public static boolean dataCheck(String[] data) {
        for(int i = 0; i< data.length; i++) {
            String cmd = data[i];
            char start = cmd.charAt(0);
            char end = cmd.charAt(2);
            
            char compare = cmd.charAt(3);
            int length = cmd.charAt(4);
            
            if(compare == '>' && getLength(start, end) <= length) return false;
            else if(compare == '<' && getLength(start, end) >= length) return false;
            else if(compare == '=' && getLength(start, end) != length) return false;
        }
        return true;
    }
    
    public static void Perm(int count, String[] data) {
        if(count == 8) {
            if(dataCheck(data)) Answer++;
            return;
        }
        
        for(int i = 0; i < 8; i++) {
            if(Checked[i]) continue;
            
            Checked[i] = true;
            Line[count] = Person[i];
            Perm(count+1, data);
            Checked[i] = false;
        }
    }
}