#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int *arr;
int n, m;

void find(vector<int> before, int depth)
{
    if (depth == m)
    {
        for (int i = 0; i < before.size(); i++)
        {
            cout << before[i] << " ";
        }
        cout << "\n";
        before.pop_back();
        return;
    }

    for (int i = 0; i < n; i++)
    {
        if (depth == 0 || before[depth - 1] < arr[i])
        {
            before.push_back(arr[i]);
            find(before, depth + 1);
            before.pop_back();
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m;

    arr = new int[n];

    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    sort(arr, arr + n);

    vector<int> before;

    find(before, 0);

    return 0;
}
