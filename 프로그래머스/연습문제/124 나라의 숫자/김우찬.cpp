/*
n % 3 -> 이 숫자 붙이고
n = (n - 1) / 3
*/
#include <string>
#include <vector>

using namespace std;

string solution(int n) {
    string answer = "";
    string temp = "";
    
    while(n > 0){
        temp += to_string(n % 3);
        n -= 1;
        if(n > 0)
            n /= 3;
    }
    
    for(int i = temp.length() - 1; i >= 0; i--){
        if(temp[i] == '0')
            temp[i] = '4';
        answer += temp[i];
    }

    return answer;
}
