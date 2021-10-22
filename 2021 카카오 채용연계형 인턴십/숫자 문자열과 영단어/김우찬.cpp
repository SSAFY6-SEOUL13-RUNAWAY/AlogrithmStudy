#include <string>
#include <vector>
#include <string.h>

using namespace std;

char st_to_int(string s){
    if(s == "zero")
        return '0';
    else if(s == "one")
        return '1';
    else if(s == "two")
        return '2';
    else if(s == "three")
        return '3';
    else if(s == "four")
        return '4';
    else if(s == "five")
        return '5';
    else if(s == "six")
        return '6';
    else if(s == "seven")
        return '7';
    else if(s == "eight")
        return '8';
    else if(s == "nine")
        return '9';
    else
        return 'x';
}

int solution(string s) {
    int answer = 0;
    string answer_str = "";
    
    string temp = "";
    for(int i = 0; i < s.length(); i++){
        if(s[i] >= '0' && s[i] <= '9'){
            if(temp != ""){
                answer_str += st_to_int(temp);
            }
            temp = "";
            answer_str += s[i];
            continue;
        }
        
        if(temp.length() >= 3){
            char num = st_to_int(temp);
            if(num != 'x'){
                answer_str += st_to_int(temp);
                temp = "";
            }
        }
        
        temp += s[i];
    }
    
    if(temp != "")
        answer_str += st_to_int(temp);
    
    answer = stoi(answer_str);
    
    return answer;
}
