#include <iostream>
#include <string>
#include <vector>
#include <math.h>
#include <string.h>

using namespace std;

int ctonum[26] = {0, 0, 1, 0, 0, 2, 0, 0, 0, 3, 0, 0, 4, 5, 0, 0, 0, 6, 0, 7, 0, 0, 0, 0, 0, 0};
int*** b;
bool* check;
vector<int> line;
int cnt;

void calu(){
    if(line.size() == 8){
        cnt++;
        return;
    }
    
    for(int i = 0; i < 8; i++){
        if(check[i] == false){
            int correct = 1;
            for(int j = 0; j < line.size(); j++){
                if(b[i][line[j]][1] != 0 && b[i][line[j]][1] != line.size() - j){
                    correct = 0;
                    break;
                }
                if(b[i][line[j]][0] != 0 && b[i][line[j]][0] > line.size() - j){
                    correct = 0;
                    break;
                }
                if(b[i][line[j]][2] != 0 && b[i][line[j]][2] < line.size() - j){
                    correct = 0;
                    break;
                }
            }

            if(correct == 1){
                check[i] = true;
                line.push_back(i);
                calu();
                line.pop_back();
                check[i] = false;
            }
        }
    }
}

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
int solution(int n, vector<string> data) {
    int answer = 0;
    b = new int**[8];
    for(int i = 0; i < 8; i++){
        b[i] = new int*[8];
        for(int j = 0; j < 8; j++){
            b[i][j] = new int[3];
            memset(b[i][j], 0, 3 * 4);
        }
    }
    check = new bool[8]();
    cnt = 0;
    
    for(int i = 0; i < n; i++){
        int flag = 2;
        int dist = data[i][4] - '0';
        int p1 = ctonum[data[i][0] - 'A'];
        int p2 = ctonum[data[i][2] - 'A'];
        if(data[i][3] == '>'){
            flag = 0;
            dist += 2;
        }
        else if(data[i][3] == '='){
            flag = 1;
            dist += 1;
        }

        if(flag == 0) {
            if(b[p1][p2][flag] == 0 || (b[p1][p2][flag] != 0 && b[p1][p2][flag] < dist)){
                b[p1][p2][flag] = dist;
                b[p2][p1][flag] = dist;
            }
        }
        else if(flag == 2){
            if(b[p1][p2][flag] == 0 || (b[p1][p2][flag] != 0 && b[p1][p2][flag] > dist)){
                b[p1][p2][flag] = dist;
                b[p2][p1][flag] = dist;
            }
        }
        else if(flag == 1){
            if(b[p1][p2][flag] == 0 || b[p1][p2][flag] != 0){
                b[p1][p2][flag] = dist;
                b[p2][p1][flag] = dist;
            }
        }
        
        if(flag == 1 && b[p1][p2][1] != 0 && b[p1][p2][1] != dist)
            return 0;
        if(b[p1][p2][0] != 0 && b[p1][p2][2] != 0 && b[p1][p2][0] > b[p1][p2][2])
            return 0;
        if(b[p1][p2][1] != 0 && b[p1][p2][0] != 0 && b[p1][p2][1] < b[p1][p2][0])
            return 0;
        if(b[p1][p2][1] != 0 && b[p1][p2][2] != 0 && b[p1][p2][1] > b[p1][p2][2])
            return 0;
    }
    
    calu();
    
    answer = cnt;
    return answer;
}
