#include <iostream>
#include <queue>

using namespace std;

int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    int *arr = new int[n];
    int *dist = new int[n];

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        dist[i]=210000000;
    }

    dist[n-1]=-1;
    dist[0]=0;

    queue<int> q;

    q.push(0);

    while (!q.empty()) {
        
        int num=q.front();
        q.pop();

        int distance=dist[num];

        for(int i=1;i<=arr[num];i++){
            if(num+i>=n) break;
            if(dist[num+i]>distance+1||dist[num+i]==-1){
                dist[num+i]=distance+1;
                q.push(num+i);
            }
        }
    }
    cout<<dist[n-1];

    return 0;
}