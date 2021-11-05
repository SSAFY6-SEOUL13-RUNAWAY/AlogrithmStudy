#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <limits.h>

using namespace std;

int calu(int a, int b){
    if(a == INT_MAX || b == INT_MAX)
        return INT_MAX;
    return a + b;
}

int solution(int n, int s, int a, int b, vector<vector<int>> fares) {
    int answer = 0;
    
    int** bo = new int*[n];
    for(int i = 0; i < n; i++){
        bo[i] = new int[n]();
        for(int j = 0; j < n; j++){
            bo[i][j] = INT_MAX;
            if(i == j)
                bo[i][j] = 0;
        }
    }
    
    for(int i = 0; i < fares.size(); i++){
        bo[fares[i][0] - 1][fares[i][1] - 1] = fares[i][2];
        bo[fares[i][1] - 1][fares[i][0] - 1] = fares[i][2];
    }
    
    for(int k = 0; k < n; k++){
        for(int i = 0; i < n; i++){
            if(k == i)
                continue;
            for(int j = 0; j < n; j++){
                if(k == j || i == j)
                    continue;
                
                bo[i][j] = min(bo[i][j], calu(bo[i][k], bo[k][j]));
            }
        }
    }

    s--;
    a--;
    b--;
    answer = bo[s][a] + bo[s][b];
    
    for(int i = 0; i < n; i++){
        if(i == s)
            continue;
        
        answer = min(answer, calu(calu(bo[s][i], bo[i][a]), bo[i][b]));
    }
    
    return answer;
}
