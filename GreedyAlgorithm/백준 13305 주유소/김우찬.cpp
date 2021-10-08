#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cout.tie(0);
  cin.tie(0);

  int n;
  cin >> n;

  unsigned long long** b = new unsigned long long*[n];
  for(int i = 0; i < n; i++)
    b[i] = new unsigned long long[2];

  //거리 입력
  for(int i = 0; i < n - 1; i++)
    cin >> b[i][1];
  //도시별 가격 입력
  for(int i = 0; i < n; i++)
    cin >> b[i][0];
  
  //계산
  unsigned long long result = 0;
  unsigned long long min_num = b[0][0];
  for(int i = 0; i < n - 1; i++){
    result += min_num * b[i][1];

    if(min_num > b[i + 1][0])
      min_num = b[i + 1][0];
  }

  cout << result;
}
