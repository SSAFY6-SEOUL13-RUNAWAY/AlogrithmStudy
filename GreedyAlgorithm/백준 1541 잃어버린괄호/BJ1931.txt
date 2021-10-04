#include <iostream>
#include <string.h>
#include <algorithm>
using namespace std;

typedef struct meeting{
  int st;
  int end;
}meeting;

bool compare(meeting a, meeting b){
  if(a.end == b.end)
    return a.st <= b.st;
  else
    return a.end <= b.end;
}

int main() {

  int n;
  cin >> n;
  meeting* ary = new meeting[n]();

  int i;
  int result = 1;

  for(i = 0; i < n; i++){
    cin >> ary[i].st >> ary[i].end;
  }

  sort(ary, ary + n, compare);

  int go = ary[0].end;
  int fi = ary[n - 1].end;

  for(i = 1; i < n; i++){
    if(go <= ary[i].st && fi >= ary[i].end){
      go = ary[i].end;
      fi = ary[n - 1].end;
      result++;
    }
  }

  

  cout << result;

  return 0;
}