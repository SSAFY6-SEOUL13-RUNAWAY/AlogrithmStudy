using namespace std;

long long solution(int w,int h) {
    long long answer = 1;
    
    long long lw = (long long)w;
    long long lh = (long long)h;
    long long x = lw;
    long long y = lh;
    if(lw > lh){
        x = lh;
        y = lw;
    }
    
    while(y % x != 0){
        int rm = y % x;
        y = x;
        x = rm;
    }
    
    long long sw = lw / x;
    long long sh = lh / x;
    
    answer = lw * lh;
    answer -= (sw + sh - 1) * x;
    
    
    return answer;
}
