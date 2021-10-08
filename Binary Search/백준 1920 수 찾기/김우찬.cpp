#include <iostream>
#include <algorithm>

using namespace std;

int n;
int* b;

int calu(int num){
  int st = 0;
  int fin = n - 1;
  
  while(fin - st > 1){
    int mid = (st + fin) / 2;
    if(b[mid] == num)
      return 1;
    else if(b[mid] > num)
      fin = mid;
    else if(b[mid] < num)
      st = mid;
  }

  if(num == b[st] || num == b[fin])
    return 1;

  return 0;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  cin >> n;

  b = new int[n];
  for(int i = 0; i < n; i++)
    cin >> b[i];
  sort(&b[0], &b[n]);

  int m;
  cin >> m;
  
  int* num = new int[m];
  for(int i = 0; i < m; i++)
    cin >> num[i];

  for(int i = 0; i < m; i++)
    cout << calu(num[i]) << "\n";
}
