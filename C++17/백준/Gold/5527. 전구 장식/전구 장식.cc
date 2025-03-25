#include <iostream>
#include <vector>

using namespace std;

int main(void) {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    int *arr = new int[n];

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int cnt = 1;
    vector<int> temp;

    for (int i = 1; i < n; i++) {
        if(arr[i]!=arr[i-1]){
            cnt++;
        }else{
            temp.push_back(cnt);
            cnt=1;
        }
    }
    temp.push_back(cnt);


    int ans=-1;

    if(temp.size()>2){
        for(int i=2;i<temp.size();i++){
            ans=max(temp[i-2]+temp[i-1]+temp[i],ans);
        }
    }else{
        ans=0;
        for(int i=0;i<temp.size();i++){
            ans+=temp[i];
        }
    }

    cout<<ans;

    return 0;
}
