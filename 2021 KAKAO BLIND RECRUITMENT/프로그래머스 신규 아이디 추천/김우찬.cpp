#include <string>
#include <vector>

using namespace std;

string solution(string new_id) {
    string answer = new_id;
    
    for(int i = 0; i < answer.length(); i++){
        if(answer[i] >= 'A' && answer[i] <= 'Z')
            answer[i] = answer[i] - 'A' + 'a';
        
        int cnt = 0;
        if(!(answer[i] >= 'A' && answer[i] <= 'Z') &&  !(answer[i] >= 'a' && answer[i] <= 'z')         
         && !(answer[i] >= '0' && answer[i] <= '9') && answer[i] != '-' && answer[i] != '_' && answer[i] != '.'){
            answer = answer.substr(0, i) + answer.substr(i + 1, answer.length() - i - 1);
            cnt++;
        }
        
        if(i < answer.length() - 1 && answer[i] == '.' &&  answer[i - 1] == '.'){
            answer = answer.substr(0, i) + answer.substr(i + 1, answer.length() - i - 1);
            cnt++;
        }
        
        i -= cnt;
    }
    
    if(answer.length() > 0 && answer[0] == '.')
        answer = answer.substr(1, answer.length() - 1);
    
    if(answer.length() > 0 && answer[answer.length() - 1] == '.')
        answer = answer.substr(0, answer.length() - 1);
    
    if(answer.length() == 0)
        answer += "a";
    
    if(answer.length() >= 16)
        answer = answer.substr(0, 15);
    
    if(answer.length() > 0 && answer[answer.length() - 1] == '.')
        answer = answer.substr(0, answer.length() - 1);
    
    while(answer.length() <= 2)
        answer += answer[answer.length() - 1];

    return answer;
}
