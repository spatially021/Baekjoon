#include <iostream>
#include <unordered_map>

using namespace std;

#define ll long long

int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    while (n--) {
        ll t;
        cin >> t;

        unordered_map<ll, int> map;

        for (ll i = 0; i < t; i++) {
            ll a;
            cin >> a;

            if (map.count(a) > 0) {
                map[a]++;
            } else {
                map.insert({a, 1});
            }
        }

        bool flag = false;
        for (const auto& pair : map) {
            if (pair.second > t / 2) {
                cout << pair.first << "\n";
                flag = true;
                break;
            }
        }

        if (!flag) {
            cout << "SYJKGW\n";
        }
    }

    return 0;
}
