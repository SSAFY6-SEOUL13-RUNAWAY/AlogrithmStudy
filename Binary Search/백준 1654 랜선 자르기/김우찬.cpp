#include <iostream>
#include <algorithm>

using namespace std;

long long* b;
long long n;
long long m;
long long result = 0;

void calu(long long st, long long fin){
  while(fin - st > 1){
    long long mid = (st + fin) / 2;
    if(mid == 0)
        break;
    long long check = 0;
    for(long long i = 0; i < n; i++)
      check += b[i] / mid;

    if(check >= m){
      if(result < mid)
        result = mid;
      st = mid;
    }
    else
      fin = mid;
  }

  long long* bm = new long long[2];
  bm[0] = fin;
  bm[1] = st;

  for(int k = 0; k < 2; k++){
    long long check = 0;
    if(bm[k] == 0)
        continue;
    for(long long i = 0; i < n; i++)
      check += b[i] / bm[k];
    
    if(check >= m){
      if(result < bm[k])
        result = bm[k];
    }
  }
}

int main() {
  cin >> n >> m;

  b = new long long[n]();
  for(long long i = 0; i < n; i++)
    cin >> b[i];

  sort(&b[0], &b[n]);

  calu(0, b[n - 1]);
  
  cout << result;
}
