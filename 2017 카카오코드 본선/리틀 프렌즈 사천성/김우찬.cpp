#include <iostream>
#include <string>
#include <vector>
#include <string.h>
#include <math.h>

using namespace std;

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
string solution(int n, int m, vector<string> board) {
    string answer = "";
    
    int p[26][2];   // 알파벳 별로 짝
    vector<pair<bool*, int>> blocking[26];  //나를 가로막는 
    bool blocked[26][26];    //내가 가로막는
    int tail_cnt = 0;

     for(int i = 0; i < 26; i++){
        memset(blocked[i], false, sizeof(bool) * 26);
        memset(p[i], -1, 4 * 2);
     }
    
    //알파벳 별로 짝인 타일 찾기
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(board[i][j] != '.' && board[i][j] != '*'){
                tail_cnt++;
                int index = 0;
                if(p[board[i][j] - 'A'][0] != -1)
                    index++;
                
                p[board[i][j] - 'A'][index] = i * m + j;
            }
        }
    }
    
    //짝인 타일 경로 사이에 있는 방해물 타일들 찾기
    for(int k = 0; k < 26; k++){
        if(p[k][0] == -1)
            continue;
        
        int x1 = p[k][0] / m;   //타일1의 x좌표
        int y1 = p[k][0] % m;   //타일1의 y좌표
        int x2 = p[k][1] / m;   //타일2의 x좌표
        int y2 = p[k][1] % m;   //타일2의 y좌표
        
        int sx = min(x1, x2);    //x좌표 시작
        int fx = max(x1, x2);    //x좌표 끝
        int sy = min(y1, y2);    //y좌표 시작
        int fy = max(y1, y2);    //y좌표 끝
        
        int px = x1;    //가로 탐색 시 x좌표
        int py = y2;    //세로 탐색 시 y좌표
        
        for(int tw = 0; tw < 2; tw++){
            bool* block_tail;
            int block_tail_cnt = 0;
            block_tail = new bool[26]();
            int ch_block = 0;
            //세로
            for(int i = sx; i <= fx; i++){
                if(board[i][py] == '*'){
                    ch_block = 1;
                    break;
                }
                else if(board[i][py] == '.' || board[i][py] == (char)('A' + k))
                    continue;
                
                else{
                    if(block_tail[board[i][py] - 'A'] == false){
                        block_tail_cnt++;
                        block_tail[board[i][py] - 'A'] = true;
                        blocked[board[i][py] - 'A'][k] = true;
                    }
                }
            }
            //가로
            for(int j = sy; j <= fy; j++){
                if(board[px][j] == '*'){
                    ch_block = 1;
                    break;
                }
                else if(board[px][j] == '.' || board[px][j] == (char)('A' + k))
                    continue;
                
                else{
                    if(block_tail[board[px][j] - 'A'] == false){
                        block_tail_cnt++;
                        block_tail[board[px][j] - 'A'] = true;
                        blocked[board[px][j] - 'A'][k] = true;
                    }
                }
            }
            
            px = x2;
            py = y1;
            
            if(ch_block == 1)
                continue;
            
            blocking[k].push_back(make_pair(block_tail, block_tail_cnt));
        }
    }
    
    tail_cnt /= 2;
    
    //타일 부수기 시작
    while(tail_cnt != 0){
        int ch_break_tail = 0;
        for(int k = 0; k < 26; k++){
            if(p[k][0] == -1)
                continue;
            
            //가능 경로 확인
            for(int i = 0; i < blocking[k].size(); i++){
                //가로 막는게 없으면(부술 수 있으면)
                if(blocking[k][i].second == 0){
                    answer += (char)(k + 'A');
                    ch_break_tail = 1;
                    p[k][0] = -1;
                    //내가 가로 막고 있던 애들 최신화
                    for(int j = 0; j < 26; j++){
                        if(blocked[k][j] == false)
                            continue;
                        
                        blocked[k][j] = false;
                        for(int l = 0; l < blocking[j].size(); l++){
                            if((blocking[j][l].first)[k] != 0){
                                (blocking[j][l].first)[k] = 0;
                                blocking[j][l].second--;
                            }
                        }
                    }
                    
                    break;
                }
            }
            
            if(ch_break_tail == 1){
                tail_cnt--;
                break;
            }
        }
        
        if(ch_break_tail == 0)
            return "IMPOSSIBLE";
    }
    
    return answer;
}
/*
1. 각 경로(1개 or 2개)에 장애물 집합을 저장 && 그 장애물들에게 방해중인 node를 저장 
2. 장애물 집합이 경로 중 하나라도 뚫린 얘 먼저 시작 (당연 앞 알파벳 부터)
3. 걔가 터진다고 하고, 나로 인해 방해 받고 있는 애들한테 가서 다 해제
4. 다시 앞 알파벳 부터 반복...2~3
5. 전체 반복해도 터뜨릴수 있는거 없으면 IMPOSSIBLE
*/
