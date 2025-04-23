#include <bits/stdc++.h>

using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);

  int n; cin >> n;

  vector<int> spaceJunk(n);
  for (int i = 0; i < n; i++)
    cin >> spaceJunk[i];

  int minJunk = *min_element(spaceJunk.begin(), spaceJunk.end());
  auto launchDay = find(spaceJunk.begin(), spaceJunk.end(), minJunk) - spaceJunk.begin();

  cout << launchDay << "\n";

  return 0;
}