class Solution {
    public String solution(int n) {
        char[] num = {'1','2','4'};
        StringBuilder answer = new StringBuilder();
        int length = 0;
        int[] tb = new int[20];
        
        tb[0] = 0;
        tb[1] = 3;
        
        // 1. 해당 값이 변환하였을 경우 길이를 찾는다
        for(int i = 2; i < 20; i++) {
            if(n <= tb[i-1]) {
                length = i-1;
                break;
            }
            tb[i] = tb[i-1]+(int)Math.pow(3,i);
        }
        // 해당 길이와 몇번째 순서인지 자른다.
        // 14 일 경우 length:3 n:2
        n -= tb[length-1];

        // 해당 길이만큼 반복     
        while(length-->0) { 
            int mok = n / (int)Math.pow(3,length);
            int na =  n % (int)Math.pow(3,length);
            if(na == 0) {
                answer.append(num[mok-1]);
                n = (int)Math.pow(3,length);
            }
            else {
                answer.append(num[mok]);
                n = na;
            }
        }
        return answer.toString();
       
    }
}