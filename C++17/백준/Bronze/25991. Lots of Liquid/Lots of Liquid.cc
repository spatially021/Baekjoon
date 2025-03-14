#include <bits/stdc++.h>

using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);

  int n; cin >> n;

  double volume = 0.0;

  for (int i = 0; i < n; i++) {
    double len; cin >> len;
    volume += pow(len, 3);
  }

  double ans = pow(volume, 1.0 / 3);
  cout.setf(ios::fixed); cout.precision(6);
  cout << ans << "\n";

  return 0;
}