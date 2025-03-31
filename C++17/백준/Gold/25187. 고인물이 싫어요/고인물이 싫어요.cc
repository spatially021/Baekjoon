#include <iostream>

using namespace std;

int N, M, Q;
int *parent;
int *clean, *dirty;

int find(int x) {
    if (parent[x] == x) {
        return x;
    }
    return parent[x] = find(parent[x]);
}

void union_(int u, int v) {
    int pu = find(u);
    int pv = find(v);

    if (pu != pv) {
        if (pu > pv) {
            swap(pu, pv);
        }
        clean[pu] += clean[pv];
        dirty[pu] += dirty[pv];
        parent[pv] = pu;
    }
}

int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M >> Q;
    parent = new int[N + 1];
    clean = new int[N + 1];
    dirty = new int[N + 1];

    for (int i = 1; i < N + 1; i++) {
        parent[i] = i;

        int w;
        cin >> w;

        if (w == 1) {
            clean[i] = 1;
            dirty[i] = 0;
        } else {
            dirty[i] = 1;
            clean[i] = 0;
        }
    }

    while (M--) {
        int u, v;
        cin >> u >> v;
        union_(u, v);
    }

    while (Q--) {
        int k;
        cin >> k;
        int p = find(k);
        if (clean[p] > dirty[p]) {
            cout << "1\n";
        } else {
            cout << "0\n";
        }
    }

    return 0;
}