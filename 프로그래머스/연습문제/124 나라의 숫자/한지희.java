class Solution {
    public String solution(int n) {
        String[] num = {"4", "1", "2"};
        String answer = "";
        while(n > 0){
            answer = num[n%3] + answer;
            
            int rest = n % 3;
            n = n/3;//몫
           // n%3
              answer = rest + answer;
          }
            return answer;
        }
}
