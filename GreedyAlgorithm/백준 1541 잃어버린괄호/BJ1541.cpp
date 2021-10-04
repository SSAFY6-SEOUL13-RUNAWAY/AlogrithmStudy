#include <iostream>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  string s;
  cin >> s;

  vector<int> v;
  
  string temp = "";
  int op = 1;
  for(int i = 0; i <= s.length(); i++){
    if(s[i] == '+'|| s[i] == '-' || i == s.length()){
      if(op == 1){
        if(v.size() == 0)
          v.push_back(stoi(temp));
        else{
          int num = v.back();
          num += stoi(temp);
          v.pop_back();
          v.push_back(num);
        }
      }
      else if(op == 2)
        v.push_back(stoi(temp));

      temp = "";

      if(i != s.length()){
        if(s[i] == '+')
          op = 1;
        else if(s[i] == '-')
          op = 2;
      }
    }
    else
      temp += s[i];
  }

  int result = v[0];
  for(int i = 1; i < v.size(); i++)
    result -= v[i];

  cout << result;
}
