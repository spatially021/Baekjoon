#include <iostream>
#include <math.h>

using namespace std;

int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    cin >> t;
    bool isPrim[20001];
    for (int i = 0; i < 20001; i++) {
        isPrim[i] = true;
    }
    isPrim[1] = false;
    for (int i = 2; i < 20001; i++) {
        if (isPrim[i]) {
            for (int j = i*2; j < 20001; j += i) {
                isPrim[j] = false;
            }
        }
    }

    while (t--) {
        int n, m;
        cin >> m >> n;

        if (n * m == 0) {
            int p = abs(n);
            if (p == 0)
                p = abs(m);

            if (isPrim[p] && p % 4 == 3) {
                cout << "P\n";
            } else {
                cout << "C\n";
            }
            continue;
        }

        int num = n * n + m * m;
        if (isPrim[num]) {
            cout << "P\n";
        } else {
            cout << "C\n";
        }
    }

    return 0;
}
