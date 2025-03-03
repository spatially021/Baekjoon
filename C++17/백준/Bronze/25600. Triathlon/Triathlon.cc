#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    ios_base ::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin>>n;

    int max_=-1;

    for(int i=0;i<n;i++){
        int a,d,g;

        cin>>a>>d>>g;

        int sum=a*(d+g);
        if(a==(d+g)) sum*=2;
        
        max_= max(max_,sum);
    }

    cout<<max_;

    return 0;
}