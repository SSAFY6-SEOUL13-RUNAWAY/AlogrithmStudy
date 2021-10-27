#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    vector<int> box;
    int i;
    int check;

    for(i = 0; i < moves.size(); i++){
      int k = 0;
      check = 0;
      while(1){
        if(k >= board.size()){
          check = 1;
          break;
        }
          
        if(board[k][moves[i] - 1] != 0)
          break;
          
        k++;
      }
        
      if(check == 1)
        continue;
        
      box.push_back(board[k][moves[i] - 1]);
      board[k][moves[i] - 1] = 0;
      if(box.size() > 1){
        if(box[box.size() - 1] == box[box.size() - 2]){
          answer += 2;
          box.pop_back();
          box.pop_back();
        }
      }
    }
    
    return answer;
}
