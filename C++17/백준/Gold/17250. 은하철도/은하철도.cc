#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int N, M;
int *parent, *planets;

int find(int x) {
    if (x == parent[x])
        return x;
    else
        return find(parent[x]);
}

int union_(int x, int y) {
    int X = find(x);
    int Y = find(y);

    if (X < Y) {
        parent[Y] = X;
        planets[X] += planets[Y];
        planets[Y] = 0;
        return planets[X];
    } else {
        parent[X] = Y;
        planets[Y] += planets[X];
        planets[X] = 0;
        return planets[Y];
    }
}

int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;

    planets = new int[N + 1];
    parent = new int[N + 1];

    for (int i = 1; i < N + 1; i++) {
        cin >> planets[i];
        parent[i] = i;
    }

    vector<int> *graph = new vector<int>[N + 1];

    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;

        if (find(a) != find(b)) {
            cout << union_(a, b);
        } else {
            cout << max(planets[find(a)], planets[find(b)]);
        }
        cout << "\n";
    }

    return 0;
}