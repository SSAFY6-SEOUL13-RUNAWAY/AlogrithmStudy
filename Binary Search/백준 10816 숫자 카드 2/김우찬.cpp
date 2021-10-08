#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
vector<int> b;
vector<pair<int, int>> cnt;

int calu(int num){
  int st = 0;
  int fin = cnt.size() - 1;

  while(fin - st > 1){
    int min = (st + fin) / 2;

    if(cnt[min].first == num)
      return cnt[min].second;
    else if(cnt[min].first > num)
      fin = min;
    else if(cnt[min].first < num)
      st = min;
  }

  if(cnt[st].first == num)
    return cnt[st].second;
  else if(cnt[fin].first == num )
    return cnt[fin].second;

  return 0;
}

int main() {
  ios::sync_with_stdio(0);
  cout.tie(0);
  cin.tie(0);

  cin >> n;
  for(int i = 0; i < n; i++){
    int temp;
    cin >> temp;
    b.push_back(temp);
  }

  sort(b.begin(), b.end());

  int count = 1;
  int num = b[0];
  for(int i = 1; i < b.size(); i++){
    if(b[i] == num){
      count++;
    }
    else{
      cnt.push_back(make_pair(num, count));
      num = b[i];
      count = 1;
    }
  }

  cnt.push_back(make_pair(num, count));

  int m;
  cin >> m;
  
  for(int i = 0; i < m; i++){
    int num;
    cin >> num;

    cout << calu(num) << " ";
  }
}
