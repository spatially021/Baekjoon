#include<bits/stdc++.h>
#define N 1001
using namespace std;
 
vector <int> Gr[N], path[N], dist(N);
int n, m;
 
void Init()
{
    for (int i{}; i < N; i++)
    {
        path[i].clear();
        Gr[i].clear();
        dist[i] = 0;
    }
    cin >> n >> m;
    for (int i, j; m--;)
    {
        cin >> i >> j;
        Gr[i].push_back(j);
    }
}
void BFS()
{
    queue <int> Q;
    for (Q.push(dist[1] = 1); Q.size();)
    {
        int now(Q.front()); Q.pop();
 
        for (int& next : Gr[now])
        {
            int cost(dist[now] + 1);
            if (!dist[next])
            {
                path[next].push_back(now);
                dist[next] = cost;
                Q.push(next);
            }
            else if (cost == dist[next])
                path[next].push_back(now);
        }
    }
}
void End()
{
    set <int> ans{ n };
 
    bitset <N> visit;
    visit[n] = 1;
 
    queue <int> Q;
    for (Q.push(n); Q.size();)
    {
        int now(Q.front()); Q.pop();
 
        for (int& next : path[now])
            if (!visit[next])
            {
                ans.insert(next);
                visit[next] = 1;
                Q.push(next);
            }
    }
    for (auto& i : ans) cout << i << ' ';
    cout << '\n';
}
int main()
{
    int t; cin >> t;
    while (t--)
    {
        Init();
        BFS();
        End();
    }
}
//->최단 경로가 2개 이상 존재할 수 있음을 생각 못함