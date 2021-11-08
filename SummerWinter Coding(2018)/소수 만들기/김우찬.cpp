#include <vector>
#include <iostream>
#include <math.h>
using namespace std;

vector<int> b;
int result;
int* check;

void prime_num(int num){
    int max = (int)sqrt(num);
    
    for(int i = 2; i <= max; i++){
        if(num % i == 0)
            return;
    }

    result++;
    return;
}

void combi(int n, int cnt, int sum){
    if(cnt == 3){
        prime_num(sum);
        return;
    }
    
    for(int i = n; i < b.size(); i++){
        if(check[i] == 0){
            check[i] = 1;
            combi(i + 1, cnt + 1, sum + b[i]);
            check[i] = 0;
        }
    }
} 

int solution(vector<int> nums) {
    int answer = -1;

    b.assign(nums.begin(), nums.end());
    result = 0;
    check = new int[nums.size()]();
    
    combi(0, 0, 0);
    
    answer = result;
    return answer;
}
